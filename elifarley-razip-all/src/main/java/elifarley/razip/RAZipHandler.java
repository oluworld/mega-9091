/* RAZipHandler -- deals with data in RAZip format * Copyright (C) 2001 Elifarley Callado Coelho  * This program is free software; you can redistribute it and/or * modify it under the terms of the GNU General Public License, version 2, * as published by the Free Software Foundation; * This program is distributed in the hope that it will be useful, * but WITHOUT ANY WARRANTY; without even the implied warranty of * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the * GNU General Public License for more details. * You should have received a copy of the GNU General Public License * along with this program; if not, write to the Free Software * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA. * See the file "RAZIP-COPYING" for the software license.  * Elifarley Callado Coelho * Belo Horizonte, Brazil * elifarley@yahoo.com * http://www.geocities.com/elifarley/ *  */package elifarley.razip;import elifarley.io.VersaStreamConstants;import elifarley.io.VersaStream;import elifarley.io.VersaStreamFactory;import elifarley.io.InflaterVersaStream;import java.util.Vector;import java.io.IOException;import java.util.Date;import java.util.zip.CRC32;public class RAZipHandler implements RAZipConstants, VersaStreamConstants {    protected RAZipVersaStream RAZ_VS;    protected CRC32 crc = new CRC32();	protected int CRC;	//protected VersaStream vs;	protected Vector<BlockInfo> cpVector; // = new Vector(30);	protected int cHeaderSize;	protected int firstBlockPos = 0;	protected long size;	protected long blockCount;	protected boolean trailerPresent;	protected boolean headerStarted = false;	protected boolean headerFinished = false;		protected int blockTrailerSize;	protected int trailerSize;	// Higher-level representation of flags		protected boolean			headerNotEncoded,			nonStandardIntegrityCheck,			saveHeaderCRC,			checkBlockIntegrity,			extendedMTime,			extendedCTime,			useTypeCreator,			saveName,			saveComment,			saveProperties,			saveResFork,			flag1Present,			saveExtraField8,			saveExtraField16,			saveExtraField32,			nonStandardTextEnc;					//	protected Date mDate, cDate;	protected boolean dataForkPresent = false;	protected boolean resForkPresent = false;		// =====================================================	// Writing preferences		// 700 * 1024: size increase: less than 0.02 %	// random: 22 bytes / s		// 64 * 1024: size increase: slightly more than 9 %	// random: 55 bytes / s		// uncompressed file:	// random: 68 bytes / s		// GZip	// random: 1.7 bits / s		protected byte compressionMethod = CM_DEFAULT;			// Integrity check used at the end of the stream	protected byte icID = INTEGRITY_CHECK_PRZ24;	protected long crcLen = 3;	// Integrity check used at the end of every block	protected byte bicID = INTEGRITY_CHECK_ADLER;	protected long bCRCLen = 2;		protected byte flgNC0 = (byte) (		0		//F_HAS_MORE_FLAG_NC |		//FNC0_NON_STANDARD_COMPRESSION		//FNC0_ENCRYPTED		//FNC0_ECC		//FNC0_HEADER_NOT_ENCODED		//FNC0_NON_STANDARD_INTEGRITY_CHECK		//FNC0_HEADER_CRC | 		//FNC0_BLOCK_INTEGRITY_CHECK | 		);	protected byte flg0 = (byte) (		//F_HAS_MORE_FLAG_BYTES |		F0_EXTENDED_MTIME_INFO |		F0_EXTENDED_CTIME_INFO | 		F0_TYPE_CREATOR |		F0_NAME |		F0_COMMENT |		F0_PROPERTIES 		//F0_RESFORK		);	protected byte flg1 = (byte) (		F1_EXTRA_FIELD_8 |		F1_EXTRA_FIELD_16 | 		F1_EXTRA_FIELD_32 |		F1_NON_STANDARD_TEXT_ENCODING		);	protected byte cipherFlg0 = (byte) (		CF0_HAS_MORE_CF |		//CF0_UNDISCLOSED |		CF0_USE_ASYMMETRIC_KEY		);	protected byte cipherFlg1 = (byte) (		CF1_SET_CIPHER |		CF1_SET_MODE |		CF1_SET_KEY_SIZE |		CF1_SET_BLOCK_SIZE |		CF1_SET_ITERATIONS |		CF1_SET_PADDING		);	protected byte cipherFlg2 = (byte) (		//CF2_HAS_MORE_ACF |		CF2_SET_CIPHER |		CF2_SET_KEY_SIZE |		CF2_SET_PADDING		);	// =====================================================	public RAZipHandler(RAZipVersaStream RAZ_VS) throws IOException {		this.RAZ_VS = RAZ_VS;		if (this.RAZ_VS.vs.getSize() != 0) {			prepare();		} else {			cpVector = new Vector<>(128);		}	}		// Higher-level manipulation of flags		public boolean getCheckBlockIntegrity() {		return checkBlockIntegrity;	}		public void setCheckBlockIntegrity(boolean b) {		throw new IllegalArgumentException("Not implemented");		//checkBlockIntegrity = b;	}		//		public byte getFlagNC0() {		return flgNC0;	}		public void setFlagNC0(byte f) {		flgNC0 = f;		System.out.println("FlagByte1 set to " + flgNC0);	}		public byte getFlag0() {		return flg0;	}	public void setFlag0(byte f) {		flg0 = f;	}	public byte getFlag1() {		return flg1;	}	public void setFlag1(byte f) {		flg1 = f;	}	public static boolean testMask(byte b, int mask) {		return (b & mask) == mask;	}		protected synchronized void writeHeader() throws IOException {				/*		if (dos != null)			throw new IOException("dos not null");		*/				VersaStream hvs = RAZ_VS.vs;				long mTime64 = System.currentTimeMillis();		long mTime32 = mTime64 / 1000;		long cTime64 = System.currentTimeMillis();		byte xfl = 0;				hvs.setPosition(0);		cHeaderSize = 0;				headerStarted = true;				//encodeFlags();				hvs.writeShort(RAZIP_MAGIC);				hvs.writeByte(flgNC0);		if (testMask(flgNC0, F_HAS_MORE_FLAG_NC)) {			throw new IOException("Capability not supported");		}		if (testMask(flgNC0, FNC0_NON_STANDARD_COMPRESSION)) {			hvs.writeByte(compressionMethod);			hvs.writeByte(xfl);		}						if (testMask(flgNC0, FNC0_ENCRYPTED)) {						hvs.writeByte(cipherFlg0);						if (!testMask(cipherFlg0, CF0_UNDISCLOSED)) {								if (testMask(cipherFlg0, CF0_HAS_MORE_CF)) {					hvs.writeByte(cipherFlg1);					byte cipherID = S_CIPHER_DEFAULT;					if (testMask(cipherFlg1, CF1_SET_CIPHER)) {						hvs.writeByte(cipherID);					}					byte cipherMode = CIPHER_MODE_DEFAULT;					if (testMask(cipherFlg1, CF1_SET_MODE)) {						hvs.writeByte(cipherMode);					}										short keySize = 8; // key size, in bytes					if (testMask(cipherFlg1, CF1_SET_KEY_SIZE)) {						hvs.writeShort(keySize);					}					short blockSize = 8; // block size, in bytes					if (testMask(cipherFlg1, CF1_SET_BLOCK_SIZE)) {						hvs.writeShort(blockSize);					}					short iter = 17;					if (testMask(cipherFlg1, CF1_SET_ITERATIONS)) {						hvs.writeShort(iter);					}					byte padding = PADDING_ONE_AND_ZEROES;					if (testMask(cipherFlg1, CF1_SET_PADDING)) {						hvs.writeByte(padding);					}				} // if (testMask(cipherFlg0, CF0_HAS_MORE_CF)) 								if (testMask(cipherFlg0, CF0_USE_ASYMMETRIC_KEY)) {										hvs.writeByte(cipherFlg2);					byte aCipherID = A_CIPHER_RSA;					if (testMask(cipherFlg2, CF2_SET_CIPHER)) {						hvs.writeByte(aCipherID);					}					byte aPadding = PADDING_PKCS1;					if (testMask(cipherFlg2, CF2_SET_PADDING)) {						hvs.writeByte(aPadding);					}				} // if (testMask(cipherFlg0, CF0_USE_ASYMMETRIC_KEY))							} // if (!testMask(cipherFlg0, CF0_UNDISCLOSED))								} // if (testMask(flgNC0, FNC0_ENCRYPTED))				byte eccID = ECC_TPC;		if (testMask(flgNC0, FNC0_ECC)) {			hvs.writeByte(eccID);		}		//				if (!testMask(flgNC0, FNC0_HEADER_NOT_ENCODED)) {			System.out.println("Writing compressed header...");			firstBlockPos = (int)hvs.getPosition();			RAZ_VS.createFirstWriteBlock();			hvs = VersaStreamFactory.getVersaStream(RAZ_VS.getBlockOutputStream());		}				hvs.writeByte(flg0);		cHeaderSize++;		if (testMask(flg0, F_HAS_MORE_FLAG_BYTES)) {			hvs.writeByte(flg1);			cHeaderSize++;		}		if (testMask(flg1, F_HAS_MORE_FLAG_BYTES)) {			throw new IOException("Capability not supported");		}				if (testMask(flgNC0, FNC0_NON_STANDARD_INTEGRITY_CHECK)) {			byte crcLenLen;						if (crcLen < 1<<8) {				crcLenLen = 1;			} else if (crcLen < 1<<16) {				crcLenLen = 2;			} else if (crcLen < 1<<24) {				crcLenLen = 3;			} else if (crcLen < 1<<32) {				crcLenLen = 4;			} else {				throw new IllegalArgumentException("Invalid crcLen: " + crcLen);			}												hvs.writeByte( ( (crcLenLen - 1) << 6) | icID);			cHeaderSize++;						switch(crcLenLen) {				case 1: hvs.writeByte((byte)crcLen); break;				case 2: hvs.writeShort((short)crcLen); break;				case 3: hvs.write24BitInt( (int) crcLen ); break;				case 4: hvs.writeInt((int)crcLen); break;				default: throw new IllegalArgumentException("crcLenLen cannot be " + crcLenLen);			}						cHeaderSize += crcLenLen;					}				if (testMask(flgNC0, FNC0_BLOCK_INTEGRITY_CHECK)) {			byte crcLenLen;						if (bCRCLen < 1<<8) {				crcLenLen = 1;			} else if (bCRCLen < 1<<16) {				crcLenLen = 2;			} else if (bCRCLen < 1<<24) {				crcLenLen = 3;			} else if (bCRCLen < 1<<32) {				crcLenLen = 4;			} else {				throw new IllegalArgumentException("Invalid bCRCLen: " + bCRCLen);			}												hvs.writeByte( ( (crcLenLen - 1) << 6) | bicID);			cHeaderSize++;						switch(crcLenLen) {				case 1: hvs.writeByte((byte)bCRCLen); break;				case 2: hvs.writeShort((short)bCRCLen); break;				case 3: hvs.write24BitInt( (int) bCRCLen ); break;				case 4: hvs.writeInt((int)bCRCLen); break;				default: throw new IllegalArgumentException("crcLenLen cannot be " + crcLenLen);			}						cHeaderSize += crcLenLen;		}		if (testMask(flg0, F0_EXTENDED_MTIME_INFO)) {			// Write modification time			hvs.writeLong(mTime64);			cHeaderSize += 8;		} else {			// Write modification time			hvs.writeInt(mTime32);			cHeaderSize += 4;		}						if (testMask(flg0, F0_EXTENDED_CTIME_INFO)) {			// Write creation time			hvs.writeLong(cTime64);			cHeaderSize += 8;		}		byte fType[] = new byte[] {65,66,67,68};		byte fCreator[] = new byte[] {69,70,71,72};		// Write type and creator info		if (testMask(flg0, F0_TYPE_CREATOR)) {		    hvs.write(fType);		    cHeaderSize += 4;		    hvs.write(fCreator);		    cHeaderSize += 4;		}		if (testMask(flg0, F_HAS_MORE_FLAG_BYTES)) {			byte textEnc = TEXT_ENC_UTF8;			// Write text encoding info			if (testMask(flg1, F1_NON_STANDARD_TEXT_ENCODING)) {			    hvs.writeByte(textEnc);			    cHeaderSize++;			}				}				// Write file name		String name = "orig-file-name";		if (testMask(flg0, F0_NAME)) {		    hvs.writeBytes(name);		    hvs.writeByte(0);		    cHeaderSize += name.length() + 1;		}						// Write file comment		String comment = "a comment";		if (testMask(flg0, F0_COMMENT)) {		    hvs.writeBytes(comment);		    hvs.writeByte(0);		    cHeaderSize += comment.length() + 1;		}		// Write properties		byte propID = PROP_ID_RECORD;		String nvp = "name1=val1" + "\29" + "name2=val2" + "\30";				if (testMask(flg0, F0_PROPERTIES)) {		    //		    hvs.writeByte(propID);		    hvs.writeBytes(nvp);		    hvs.writeByte(0);		    cHeaderSize += nvp.length() + 2;		    //		    propID = PROP_ID_XML;		    hvs.writeByte(propID);		    hvs.writeBytes(nvp);		    hvs.writeByte(0);		    cHeaderSize += nvp.length() + 2;		    hvs.writeByte(PROP_END);			cHeaderSize++;					}		if (testMask(flg0, F_HAS_MORE_FLAG_BYTES)) {		int nef = 5; // just to test it					// write extra field 8 and subfields			if (testMask(flg1 , F1_EXTRA_FIELD_8)) {			    			    System.out.println("Writing EXTRA_FIELD_8");			    int SID, sLen;			    			    byte buf[] = new byte[65536];			    while (nef > 0) {			    	SID = (short) (nef-- * 3 + 5);			    	sLen = (byte) (7 + nef);				    System.out.println("SID: " + SID + "; sLen: " + sLen);				    hvs.writeShort(SID);				    hvs.writeByte(sLen);			    	hvs.write(buf, 0, sLen);					cHeaderSize += 3 + sLen;			    }			    			    hvs.writeShort(SID_NMS);			    cHeaderSize += 2;			    			}			if ( (flg1 & (0xE0) ) != 0) {				throw new IOException("Capability not supported");				}						// write extra field 16 and subfields			if (testMask(flg1 , F1_EXTRA_FIELD_16)) {			    System.out.println("Writing EXTRA_FIELD_16");			    nef = 4;			    int SID, sLen;			    			    byte buf[] = new byte[65536];			    while (nef > 0) {			    	SID = (short) (nef-- * 3 + 5);			    	sLen = (short) (7 + nef);				    System.out.println("SID: " + SID + "; sLen: " + sLen);				    hvs.writeShort(SID);				    hvs.writeShort(sLen);			    	hvs.write(buf, 0, sLen);					cHeaderSize += 4 + sLen;			    }			    			    hvs.writeShort(SID_NMS);			    cHeaderSize += 2;			    			}						// write extra field 32 and subfields			if (testMask(flg1 , F1_EXTRA_FIELD_32)) {			    System.out.println("Writing EXTRA_FIELD_32");			    nef = 3;			    int SID;			    long sLen;			    			    byte buf[] = new byte[65536];			    while (nef > 0) {			    	SID = (short) (nef-- * 3 + 5);			    	sLen = (7 + nef);				    System.out.println("SID: " + SID + "; sLen: " + sLen);				    hvs.writeShort(SID);				    hvs.writeInt(sLen);			    	hvs.write(buf, 0, (int) sLen);					cHeaderSize += 6 + sLen;			    }			    			    hvs.writeShort(SID_NMS);			    cHeaderSize += 2;			    			}		}				// Write optional header CRC		if (testMask(flgNC0, FNC0_HEADER_CRC)) {		    int v = 0; //(int)crc.getValue() & 0xffff;		    hvs.writeShort(v);		    cHeaderSize += 2;		}		if (testMask(flgNC0, FNC0_HEADER_NOT_ENCODED)) {			firstBlockPos = (int)hvs.getPosition();			cHeaderSize = 0;			RAZ_VS.createFirstWriteBlock();		} else {			if (cHeaderSize != RAZ_VS.def.getTotalIn()) {				System.out.println("cHeaderSize: " + cHeaderSize);				System.out.println("def.getTotalIn(): " + RAZ_VS.def.getTotalIn());			}		}				System.out.println("cHeaderSize: " + cHeaderSize);		headerFinished = true;	}	protected synchronized void readHeader() throws IOException {		cHeaderSize = 0;		VersaStream hvs = RAZ_VS.vs;				// Read RAZIP_MAGIC		if (hvs.readShort() != RAZIP_MAGIC) {			throw new IOException("Not a RAZip file");		}						// Read flag bytes		//byte flgNC0, flg0, flg1 = 0;				flgNC0 = hvs.readByte();						if (testMask(flgNC0, F_HAS_MORE_FLAG_NC)) {			throw new IOException("Capability not supported");		}				byte cm = CM_DEFAULT;		if (testMask(flgNC0, FNC0_NON_STANDARD_COMPRESSION)) {			// Read compression method			cm = hvs.readByte();			// Read xfl			byte xfl = hvs.readByte();		}		if (cm != CM_DEFLATE) {			throw new IOException("Unsupported compression method: " + cm);		} 		if (testMask(flgNC0, FNC0_ENCRYPTED)) {						// TO DO: put the next lines in their proper place			int sCipherID = S_CIPHER_DEFAULT;			int cMode = CIPHER_MODE_DEFAULT;			int keySize = 8;			int cBlockSize;			int cIter;			int cPadding;			int aCipherID = A_CIPHER_RSA;			int aKeySize;			int aPadding;			// ----------------------------------------------			cipherFlg0 = hvs.readByte();						if (testMask(cipherFlg0, CF0_UNDISCLOSED)) {				System.out.println("Encryption info is not stored in this stream;");				System.out.println("User must supply this info");			} else {								if (testMask(cipherFlg0, CF0_HAS_MORE_CF)) {					cipherFlg1 = hvs.readByte();										if (testMask(cipherFlg1, CF1_SET_CIPHER)) {						sCipherID = hvs.readUnsignedByte();					}					if (testMask(cipherFlg1, CF1_SET_MODE)) {						cMode = hvs.readUnsignedByte();					}					if (testMask(cipherFlg1, CF1_SET_KEY_SIZE)) {						keySize = hvs.readUnsignedShort();					}										if (testMask(cipherFlg1, CF1_SET_BLOCK_SIZE)) {						cBlockSize = hvs.readUnsignedShort();					}					if (testMask(cipherFlg1, CF1_SET_ITERATIONS)) {						cIter = hvs.readUnsignedShort();					}					if (testMask(cipherFlg1, CF1_SET_PADDING)) {						cPadding = hvs.readUnsignedByte();					}				} // if (testMask(cipherFlg0, CF0_HAS_MORE_CF))								if (testMask(cipherFlg0, CF0_USE_ASYMMETRIC_KEY)) {									cipherFlg2 = hvs.readByte();										if (testMask(cipherFlg2, CF2_SET_CIPHER)) {						aCipherID = hvs.readUnsignedByte();					}									if (testMask(cipherFlg2, CF2_SET_KEY_SIZE)) {						aKeySize = hvs.readUnsignedShort();					}					if (testMask(cipherFlg2, CF2_SET_PADDING)) {						aPadding = hvs.readUnsignedByte();					}				} // if (testMask(cipherFlg0, CF0_USE_ASYMMETRIC_KEY))							} // if (!testMask(cipherFlg0, CF0_UNDISCLOSED)) {					} // if (testMask(flgNC0, FNC0_ENCRYPTED))					if (testMask(flgNC0, FNC0_ECC)) {			int eccID = hvs.readUnsignedByte();			System.out.println("Error correction code ID: " + eccID);		}				//				if (!testMask(flgNC0, FNC0_HEADER_NOT_ENCODED)) {			firstBlockPos = (int)hvs.getPosition();			hvs = RAZ_VS.getIVS(firstBlockPos, 0);		}		//				flg0 = hvs.readByte();		cHeaderSize++;		if (testMask(flg0, F_HAS_MORE_FLAG_BYTES)) {			flg1 = hvs.readByte();			cHeaderSize++;		}				if (testMask(flg1, F_HAS_MORE_FLAG_BYTES)) {			throw new IOException("Capability not supported");		}				// All flags have been read, so let's decode them		decodeFlags();		if (nonStandardIntegrityCheck) {			byte crcLenLen;			crcLenLen = hvs.readByte( );			cHeaderSize++;			icID = (byte) (crcLenLen & 0x3F);			crcLenLen = (byte) ( ((crcLenLen >> 6) + 1) & 3);						System.out.println("icID: " + icID);			System.out.println("crcLenLen: " + crcLenLen);						switch(crcLenLen) {				case 1: crcLen = hvs.readByte(); break;				case 2: crcLen = hvs.readShort(); break;				case 3: crcLen = hvs.read24BitInt(); break;				case 4: crcLen = hvs.readUnsignedInt(); break;				default: throw new IllegalArgumentException("crcLenLen cannot be " + crcLenLen);			}						cHeaderSize += crcLenLen;						trailerSize = (int)crcLen + MIN_TRAILER_SIZE;						System.out.println("crcLen: " + crcLen);		}				if (checkBlockIntegrity) {						byte crcLenLen;			crcLenLen = hvs.readByte( );			cHeaderSize++;			bicID = (byte)(crcLenLen & 0x3F);			crcLenLen = (byte)( ( (crcLenLen >> 6) + 1 ) & 3);						System.out.println("bicID: " + bicID);			System.out.println("crcLenLen: " + crcLenLen);						switch(crcLenLen) {				case 1: bCRCLen = hvs.readByte(); break;				case 2: bCRCLen = hvs.readShort(); break;				case 3: bCRCLen = hvs.read24BitInt(); break;				case 4: bCRCLen = hvs.readUnsignedInt(); break;				default: throw new IllegalArgumentException("crcLenLen cannot be " + crcLenLen);			}						cHeaderSize += crcLenLen;			blockTrailerSize = (int)bCRCLen + MIN_BLOCK_TRAILER_SIZE;						System.out.println("bCRCLen: " + bCRCLen);		}		long mTime32, mTime64, cTime64;				if (extendedMTime) {			// Read modification time			mTime64 = hvs.readLong();			cHeaderSize += 8;						mDate = new Date(mTime64);			System.out.println("Modification date: " + mDate);				} else {			// Read modification time			mTime32 = hvs.readInt();			cHeaderSize += 4;						mDate = new Date(1000 * mTime32);			System.out.println("Modification date (1-second precision): " + mDate);				}		if (extendedCTime) {			// Read creation time			cTime64 = hvs.readLong();			cHeaderSize += 8;						cDate = new Date(cTime64);			System.out.println("Creation date: " + cDate);					}				byte fType[] = new byte[4];		byte fCreator[] = new byte[4];		if (useTypeCreator) {		    hvs.read(fType);		    hvs.read(fCreator);		    cHeaderSize += 8;		    System.out.println("TYPE / CREATOR: " + new String(fType) + "/" + new String(fCreator));		}		if (flag1Present) {			byte textEnc;			if (nonStandardTextEnc) {				// Read text encoding info				textEnc = hvs.readByte();				cHeaderSize++;			    System.out.println("Text encoding: " + textEnc);			}				}				// Read file name		hvs.setNewLine("\0");		String name = null;		if (saveName) {		    name = hvs.readLine();		    cHeaderSize += name.length() + 1;		    System.out.println("Name: '" + name + "'");		}		// Read file comment		String comments = null;		if (saveComment) {		    comments = hvs.readLine();		    cHeaderSize += comments.length() + 1;		    System.out.println("Comment: '" + comments + "'");		}		String nvp = null;		byte propID;				// Read properties		if (saveProperties) {		    while ( (propID = hvs.readByte() ) != PROP_END) {			    nvp = hvs.readLine();			    cHeaderSize += nvp.length() + 2;			    System.out.println("PROP_ID: " + propID);			    System.out.println("Properties: '" + nvp + "'");			}			cHeaderSize++;		}		if (flag1Present) {			// Read extra field 8 and subfields			if (saveExtraField8) {				byte buf[] = new byte[65536];				int SID, sLen;							    System.out.println("Reading EXTRA_FIELD_8");		    	while ((SID = hvs.readUnsignedShort()) != SID_NMS) {			    	sLen = hvs.readUnsignedByte();			    	hvs.readFully(buf, 0, sLen);			    	cHeaderSize += 3 + sLen;			    	System.out.println("Subfield ID: " + SID + "; sLen: " + sLen);		    	}		    					cHeaderSize += 2;						}			if ( (flg1 & (0xE0) ) != 0) {				throw new IOException("Capability not supported");				}			// Read extra field 16 and subfields			if (saveExtraField16) {			    System.out.println("Reading EXTRA_FIELD_16");				byte buf[] = new byte[65536];				int SID, sLen;						    	while ((SID = hvs.readUnsignedShort()) != SID_NMS) {			    	sLen = hvs.readUnsignedShort();			    	hvs.readFully(buf, 0, sLen);			    	cHeaderSize += 4 + sLen;			    	System.out.println("Subfield ID: " + SID + "; sLen: " + sLen);		    	}		    			    	cHeaderSize += 2;			}			// Read extra field 32 and subfields			if (saveExtraField32) {			    System.out.println("Reading EXTRA_FIELD_32");				byte buf[] = new byte[65536];				int SID;				long sLen;						    	while ((SID = hvs.readUnsignedShort()) != SID_NMS) {			    	sLen = hvs.readUnsignedInt();			    	hvs.readFully(buf, 0, (int) sLen);			    	cHeaderSize += 6 + sLen;			    	System.out.println("Subfield ID: " + SID + "; sLen: " + sLen);		    	}		    					cHeaderSize += 2;						}					}		// Check header CRC		if (saveHeaderCRC) {		    		    int v = 0; // (int)crc.getValue() & 0xffff;		    if (hvs.readUnsignedShort() != v) {				throw new IOException("Header checksum failed");		    }						cHeaderSize += 2;		}				if (headerNotEncoded) {			firstBlockPos = (int)hvs.getPosition();			cHeaderSize = 0;		} else {			if (cHeaderSize != ((InflaterVersaStream)hvs).getInflater().getTotalOut()) {				System.out.println("cHeaderSize: " + cHeaderSize);				System.out.println("inf.getTotalOut(): " + ((InflaterVersaStream)hvs).getInflater().getTotalOut());				//cHeaderSize = ((InflaterVersaStream)hvs).inf.getTotalOut();				throw new IOException("Compressed header sizes don't match");			}		}	}	protected synchronized void writeTrailer() throws IOException {		if (trailerPresent)			throw new IOException("Trailer is already present");		//vs.seek(0, FROM_END);		switch ((int)crcLen) {			//case 0: throw new IllegalArgumentException("bCRCLen cannot be zero");			case 1: RAZ_VS.vs.writeByte( (byte) (CRC & 0xFF) ); break;			case 2: RAZ_VS.vs.writeShort( (short) (CRC & 0xFFFF) ); break;			case 3: RAZ_VS.vs.write24BitInt( CRC ); break;			case 4: RAZ_VS.vs.writeInt( CRC ); break;			default: throw new IOException("Unimplemented crcLen: " + crcLen);		}		trailerPresent = true;		}		protected synchronized void writeBlockTrailer(BlockInfo block) throws IOException {		//BlockInfo block = (BlockInfo)cpVector.elementAt((int)i);		//System.out.println("Writing block trailer; cPos: " + block.cPos +"; uLen: " + block.uLen + " ("+Integer.toHexString(block.uLen)+"); cLen: " + block.cLen + " ("+Integer.toHexString(block.cLen)+"); Gain: " + ( 100 * (block.uLen - block.cLen) / block.uLen) + " %");		RAZ_VS.vs.writeInt( (block.cLen & 0x7fffffff) | (block.isLastBlockInFork? 1<<31:0) );		RAZ_VS.vs.writeInt(block.uLen);				if (checkBlockIntegrity) {			switch ((int)bCRCLen) {				case 0: throw new IllegalArgumentException("bCRCLen cannot be zero");				case 1: RAZ_VS.vs.writeByte( (byte) (block.CRC & 0xFF) ); break;				case 2: RAZ_VS.vs.writeShort( (short) (block.CRC & 0xFFFF) ); break;				case 3: RAZ_VS.vs.write24BitInt( block.CRC ); break;				case 4: RAZ_VS.vs.writeInt( block.CRC ); break;				default: throw new IOException("Unimplemented bCRCLen: " + bCRCLen);			}		}							/*		switch (blockCRCKind) {			case 0: System.out.println("no block CRC written"); break;			case 1: System.out.println("byte CRC written"); break;			case 2: System.out.println("short CRC written"); break;			case 3: System.out.println("int CRC written"); break;			default: throw new IOException("Invalid blockCRCKind: " + blockCRCKind);		}			*/				block.flushed = true;	}	protected synchronized void prepare() throws IOException {				size = 0;		blockCount = 0;						int cLen, uLen;		long cPos = 0, uPos = 0;		RAZ_VS.vs.setPosition(0);				readHeader();			size = -cHeaderSize;				// read stream info in quick mode (needs seeking)				if (RAZ_VS.vs.getSize() <= firstBlockPos) // we have a header but no blocks			throw new IOException("No block found");				System.out.println("Trailer size: " + trailerSize);		System.out.println("Block trailer size: " + blockTrailerSize);		System.out.println("firstBlockPos: " + firstBlockPos);				try {			cPos = RAZ_VS.vs.seek(-trailerSize, FROM_END);						switch((int)crcLen) {				case 1: CRC = RAZ_VS.vs.readUnsignedByte(); break;				case 2: CRC = RAZ_VS.vs.readUnsignedShort(); break;				case 3: CRC = RAZ_VS.vs.readUnsigned24BitInt(); break;				case 4: CRC = RAZ_VS.vs.readInt(); break;				default: throw new IllegalArgumentException("Unimplemented feature");			}						trailerPresent = true;			System.out.println("Stream CRC: " + CRC);		} catch (IOException ioe) {			throw new IOException("RAZip file too small");		}						try {			cPos = RAZ_VS.vs.seek( - (blockTrailerSize + trailerSize), FROM_END);		} catch (IOException ioe) {			throw new IOException("RAZip file too small");		}				if (cPos < firstBlockPos)			throw new IOException("First block before expected position");				// create block vector		Vector<BlockInfo> v = new Vector<>(512);		//System.out.println("Will start while loop (cPos >= firstBlockPos)");				boolean ISBIF;		int bCRC = 0;				while (cPos >= firstBlockPos) {						RAZ_VS.vs.setPosition(cPos);			//System.out.println("cPos: " + cPos);						cLen = RAZ_VS.vs.readInt();						ISBIF = cLen >>> 31 == 1 ? true:false;									cLen = cLen & 0x7fffffff;						size += (uLen = RAZ_VS.vs.readInt());						if (checkBlockIntegrity) {							switch((int)bCRCLen/*blockCRCKind*/) {					//case 0: break;					case 1: bCRC = RAZ_VS.vs.readUnsignedByte(); break;					case 2: bCRC = RAZ_VS.vs.readUnsignedShort(); break;					case 3: bCRC = RAZ_VS.vs.readUnsigned24BitInt(); break;					case 4: bCRC = RAZ_VS.vs.readInt(); break;					default: throw new IOException("Unimplemented bCRCLen: " + bCRCLen);				} 								//System.out.println("bCRC: " + bCRC);							}									v.addElement(new BlockInfo( cLen,  uLen,  cPos - cLen,  -1 /*uPos*/, bCRC, ISBIF));			//System.out.println("blockCount: " + blockCount + "; cPos: " + (cPos - cLen) + "; cLen: " + cLen + "; uLen: " + uLen);						cPos -= (cLen + blockTrailerSize);			blockCount++;		}						if (v.size() < 1)			throw new IOException("No block found");				RAZ_VS.lastBO.block = v.elementAt(0);		RAZ_VS.lastBO.uOff = 0;				// reorder block vector and set uPos		BlockInfo cbi = null;		long theUPos = 0;				cpVector = null;		cpVector = new Vector<>(v.size());		for (int i = v.size() - 1; i >= 0; i--) {			cbi = v.elementAt(i);			cbi.uPos = theUPos;			theUPos += cbi.uLen;			cpVector.addElement(cbi);		}				if ( size + cHeaderSize != cbi.uPos + cbi.uLen ) {					System.out.println("cbi.uPos + cbi.uLen: " + (cbi.uPos + cbi.uLen) );			System.out.println("size: " + size);			System.out.println("cHeaderSize: " + cHeaderSize);						throw new IOException("Invalid last block position"); 		}				// Sets currentBO to the first block		//currentBO.block = (BlockInfo)cpVector.elementAt(0);		//currentBO.uOff = 0;				RAZ_VS.size = this.size;						System.out.println("Uncompressed size: " + size);				if (cHeaderSize != 0) {			System.out.println("Uncompressed header size: " + cHeaderSize);		}				System.out.println("Blocks: " + cpVector.size());	}			protected void decodeFlags() {			headerNotEncoded 			= testMask(flgNC0, FNC0_HEADER_NOT_ENCODED);		nonStandardIntegrityCheck 	= testMask(flgNC0, FNC0_NON_STANDARD_INTEGRITY_CHECK);		saveHeaderCRC 				= testMask(flgNC0, FNC0_HEADER_CRC);		checkBlockIntegrity 		= testMask(flgNC0, FNC0_BLOCK_INTEGRITY_CHECK);				extendedMTime 				= testMask(flg0, F0_EXTENDED_MTIME_INFO);		extendedCTime 				= testMask(flg0, F0_EXTENDED_CTIME_INFO);		useTypeCreator 				= testMask(flg0, F0_TYPE_CREATOR);		saveName 					= testMask(flg0, F0_NAME);		saveComment 				= testMask(flg0, F0_COMMENT);		saveProperties 				= testMask(flg0, F0_PROPERTIES);		saveResFork 				= testMask(flg0, F0_RESFORK);				flag1Present = testMask(flg0, F_HAS_MORE_FLAG_BYTES);				if (flag1Present) {						saveExtraField8 	= testMask(flg1, F1_EXTRA_FIELD_8);			saveExtraField16 	= testMask(flg1, F1_EXTRA_FIELD_16);			saveExtraField32 	= testMask(flg1, F1_EXTRA_FIELD_32);			nonStandardTextEnc 	= testMask(flg1, F1_NON_STANDARD_TEXT_ENCODING);		}			}	protected void encodeFlags() {		flgNC0 = 0;		flgNC0 = (byte) (flgNC0 | (headerNotEncoded 			? FNC0_HEADER_NOT_ENCODED : 0));		flgNC0 = (byte) (flgNC0 | (nonStandardIntegrityCheck 	? FNC0_NON_STANDARD_INTEGRITY_CHECK : 0));		flgNC0 = (byte) (flgNC0 | (saveHeaderCRC 				? FNC0_HEADER_CRC : 0));		flgNC0 = (byte) (flgNC0 | (checkBlockIntegrity 			? FNC0_BLOCK_INTEGRITY_CHECK : 0));		flg0 = 0;		flg0 = (byte) (flg0 | (extendedMTime 	? F0_EXTENDED_MTIME_INFO : 0));		flg0 = (byte) (flg0 | (extendedCTime 	? F0_EXTENDED_CTIME_INFO : 0));		flg0 = (byte) (flg0 | (useTypeCreator 	? F0_TYPE_CREATOR : 0));		flg0 = (byte) (flg0 | (saveName 		? F0_NAME : 0));		flg0 = (byte) (flg0 | (saveComment 		? F0_COMMENT : 0));		flg0 = (byte) (flg0 | (saveProperties 	? F0_PROPERTIES : 0));		flg0 = (byte) (flg0 | (saveResFork 		? F0_RESFORK : 0));		flg1 = 0;		flg1 = (byte) (flg1 | (saveExtraField8 		? F1_EXTRA_FIELD_8 : 0));		flg1 = (byte) (flg1 | (saveExtraField16 	? F1_EXTRA_FIELD_16 : 0));		flg1 = (byte) (flg1 | (saveExtraField32 	? F1_EXTRA_FIELD_32 : 0));		flg1 = (byte) (flg1 | (nonStandardTextEnc 	? F1_NON_STANDARD_TEXT_ENCODING : 0));		flag1Present = (flg1 != 0);				}	}