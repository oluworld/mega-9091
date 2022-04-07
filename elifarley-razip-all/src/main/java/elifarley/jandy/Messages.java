/*CopyrightPortions of this software are Copyright (c) 1993 -2001, Chad Z. Hower (Kudzu) and the Indy Pit Crew -http://www.nevrona.com/Indy/Portions of this software are Copyright (c) 2001, Elifarley Callado Coelho -http://www.geocities.com/elifarley/LicenseRedistribution and use in source and binary forms,with or without modification, are permitted provided thatthe following conditions are met:*	Redistributions of source code must retain the abovecopyright notice, this list of conditions and the followingdisclaimer. *	Redistributions in binary form must reproduce the abovecopyright notice, this list of conditions and the followingdisclaimer in the documentation, about box and/or othermaterials provided with the distribution. *	No personal names or organizations names associatedwith the Indy project may be used to endorse or promoteproducts derived from this software without specific priorwritten permission of the specific individual ororganization. THIS SOFTWARE IS PROVIDED BY Chad Z. Hower (Kudzu) and theIndy Pit Crew "AS IS'' AND ANY EXPRESS OR IMPLIEDWARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIEDWARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULARPURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS ORCONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUTNOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER INCONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OROTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THISSOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */package elifarley.jandy;public interface Messages {    String NET_NEWLINE = "\r\n";    String RS0BytesWereSent = "0 bytes were sent.";    String RSAlreadyConnected = "Already connected.";    String RSByteIndexOutOfBounds = "Byte index out of range.";    String RSCannotAllocateSocket = "Cannot allocate socket.";    String RSConnectionClosedGracefully = "Connection Closed Gracefully.";    String RSCouldNotBindSocket = "Could not bind socket. Address and port are already in use.";    String RSFailedTimeZoneInfo = "Failed attempting to retrieve time zone information.";    String RSNoBindingsSpecified = "No bindings specified.";    String RSOnExecuteNotAssigned = "OnExecute not assigned.";    String RSNotAllBytesSent = "Not all bytes sent.";    String RSNotEnoughDataInBuffer = "Not enough data in buffer.";    String RSPackageSizeTooBig = "Package Size Too Big.";    String RSUDPReceiveError0 = "UDP Receive Error = 0.";    String RSRawReceiveError0 = "Raw Receive Error = 0.";    String RSICMPReceiveError0 = "ICMP Receive Error = 0.";    String RSWinsockInitializationError = "Winsock Initialization Error.";    String RSCouldNotLoad = "%s could not be loaded.";    String RSSetSizeExceeded = "Set Size Exceeded.";    String RSThreadClassNotSpecified = "Thread Class Not Specified.";    String RSCannotChangeDebugTargetAtWhileActive = "Cannot change target while active.";    String RSOnlyOneAntiFreeze = "Only one TIdAntiFreeze can exist per application.";    String RSInterceptPropIsNil = "InterceptEnabled cannot be set to true when Intercept is nil.";    String RSInterceptPropInvalid = "Intercept value is not valid";    String RSObjectTypeNotSupported = "Object type not supported.";    String RSAcceptWaitCannotBeModifiedWhileServerIsActive = "AcceptWait property cannot be modified while server is active.";    String RSNoExecuteSpecified = "No execute handler found.";    // Status Strings    String RSStatusResolving = "Resolving hostname %s.";    String RSStatusConnecting = "Connecting to %s.";    String RSStatusConnected = "Connected.";    String RSStatusDisconnecting = "Disconnecting from %s.";    String RSStatusDisconnected = "Not connected.";    // NNTP Exceptions    String RSNNTPConnectionRefused = "Connection explicitly refused by NNTP server.";    String RSNNTPStringListNotInitialized = "Stringlist not initialized!";    String RSNNTPNoOnNewsgroupList = "No OnNewsgroupList event has been defined.";    String RSNNTPNoOnNewGroupsList = "No OnNewGroupsList event has been defined.";    String RSNNTPNoOnNewNewsList = "No OnNewNewsList event has been defined.";    // HTTP Status    String RSHTTPContinue = "Continue";    String RSHTTPSwitchingProtocols = "Switching protocols";    String RSHTTPOK = "OK";    String RSHTTPCreated = "Created";    String RSHTTPAccepted = "Accepted";    String RSHTTPNonAuthoritativeInformation = "Non-authoritative Information";    String RSHTTPNoContent = "No Content";    String RSHTTPResetContent = "Reset Content";    String RSHTTPPartialContent = "Partial Content";    String RSHTTPMovedPermanently = "Moved Permanently";    String RSHTTPMovedTemporarily = "Moved Temporarily";    String RSHTTPSeeOther = "See Other";    String RSHTTPNotModified = "Not Modified";    String RSHTTPUseProxy = "Use Proxy";    String RSHTTPBadRequest = "Bad Request";    String RSHTTPUnauthorized = "Unauthorized";    String RSHTTPForbidden = "Forbidden";    String RSHTTPNotFound = "Not Found";    String RSHTTPMethodNotAllowed = "Method not allowed";    String RSHTTPNotAcceptable = "Not Acceptable";    String RSHTTPProxyAuthenticationRequired = "Proxy Authentication Required";    String RSHTTPRequestTimeout = "Request Timeout";    String RSHTTPConflict = "Conflict";    String RSHTTPGone = "Gone";    String RSHTTPLengthRequired = "Length Required";    String RSHTTPPreconditionFailed = "Precondition Failed";    String RSHTTPRequestEntityToLong = "Request Entity To Long";    String RSHTTPRequestURITooLong = "Request-URI Too Long. 256 Chars max";    String RSHTTPUnsupportedMediaType = "Unsupported Media Type";    String RSHTTPInternalServerError = "Internal Server Error";    String RSHTTPNotImplemented = "Not Implemented";    String RSHTTPBadGateway = "Bad Gateway";    String RSHTTPServiceUnavailable = "Service Unavailable";    String RSHTTPGatewayTimeout = "Gateway timeout";    String RSHTTPHTTPVersionNotSupported = "HTTP version not supported";    String RSHTTPUnknownResponseCode = "Unknown Response Code";    // HTTP Other    String RSHTTPHeaderAlreadyWritten = "Header has already been written.";    String RSHTTPErrorParsingCommand = "Error in parsing command.";    String RSHTTPUnsupportedAuthorisationScheme = "Unsupported authorization scheme.";    String RSHTTPCannotSwitchSessionStateWhenActive = "Cannot change session state when the server is active.";    // FTP    String RSFTPUnknownHost = "Unknown";    // Property editor exceptions    String RSCorruptServicesFile = "%s is corrupt.";    String RSInvalidServiceName = "%s is not a valid service.";    // Stack Error Messages    String RSStackError = "Socket Error # %d" + "\r\n" + "%s";    String RSStackEINTR = "Interrupted system call.";    String RSStackEBADF = "Bad file number.";    String RSStackEACCES = "Access denied.";    String RSStackEFAULT = "Bad address.";    String RSStackEINVAL = "Invalid argument.";    String RSStackEMFILE = "Too many open files.";    String RSStackEWOULDBLOCK = "Operation would block. ";    String RSStackEINPROGRESS = "Operation now in progress.";    String RSStackEALREADY = "Operation already in progress.";    String RSStackENOTSOCK = "Socket operation on non-socket.";    String RSStackEDESTADDRREQ = "Destination address required.";    String RSStackEMSGSIZE = "Message too long.";    String RSStackEPROTOTYPE = "Protocol wrong type for socket.";    String RSStackENOPROTOOPT = "Bad protocol option.";    String RSStackEPROTONOSUPPORT = "Protocol not supported.";    String RSStackESOCKTNOSUPPORT = "Socket type not supported.";    String RSStackEOPNOTSUPP = "Operation not supported on socket.";    String RSStackEPFNOSUPPORT = "Protocol family not supported.";    String RSStackEAFNOSUPPORT = "Address family not supported by protocol family.";    String RSStackEADDRINUSE = "Address already in use.";    String RSStackEADDRNOTAVAIL = "Can\'t assign requested address.";    String RSStackENETDOWN = "Network is down.";    String RSStackENETUNREACH = "Network is unreachable.";    String RSStackENETRESET = "Net dropped connection or reset.";    String RSStackECONNABORTED = "Software caused connection abort.";    String RSStackECONNRESET = "Connection reset by peer.";    String RSStackENOBUFS = "No buffer space available.";    String RSStackEISCONN = "Socket is already connected.";    String RSStackENOTCONN = "Socket is not connected.";    String RSStackESHUTDOWN = "Cannot send or receive after socket is closed.";    String RSStackETOOMANYREFS = "Too many references, can\'t splice.";    String RSStackETIMEDOUT = "Connection timed out.";    String RSStackECONNREFUSED = "Connection refused.";    String RSStackELOOP = "Too many levels of symbolic links.";    String RSStackENAMETOOLONG = "File name too long.";    String RSStackEHOSTDOWN = "Host is down.";    String RSStackEHOSTUNREACH = "No route to host.";    String RSStackENOTEMPTY = "Directory not empty";    String RSStackEPROCLIM = "Too many processes.";    String RSStackEUSERS = "Too many users.";    String RSStackEDQUOT = "Disk Quota Exceeded.";    String RSStackESTALE = "Stale NFS file handle.";    String RSStackEREMOTE = "Too many levels of remote in path.";    String RSStackSYSNOTREADY = "Network subsystem is unavailable.";    String RSStackVERNOTSUPPORTED = "WINSOCK DLL Version out of range.";    String RSStackNOTINITIALISED = "Winsock not loaded yet.";    String RSStackHOST_NOT_FOUND = "Host not found.";    String RSStackTRY_AGAIN = "Non-authoritative response (try again or check DNS setup).";    String RSStackNO_RECOVERY = "Non-recoverable errors: FORMERR, REFUSED, NOTIMP.";    String RSStackNO_DATA = "Valid name, no data record (check DNS setup).";    String RSCMDNotRecognized = "command not recognized";    String RSGopherNotGopherPlus = "%s is not a Gopher+ server";    String RSCodeNoError = "RCode NO Error";    String RSCodeQueryFormat = "DNS Server Reports Query Format Error";    String RSCodeQueryServer = "DNS Server Reports Query Server Error";    String RSCodeQueryName = "DNS Server Reports Query Name Error";    String RSCodeQueryNotImplemented = "DNS Server Reports Query Not Implemented Error";    String RSCodeQueryQueryRefused = "DNS Server Reports Query Refused Error";    String RSCodeQueryUnknownError = "Server Returned Unknown Error";    String RSDNSMFIsObsolete = "MF is an Obsolete Command. USE MX.";    String RSDNSMDISObsolete = "MD is an Obsolete Command. Use MX.";    String RSDNSMailAObsolete = "MailA is an Obsolete Command. USE MX.";    String RSDNSMailBNotImplemented = "-Err 501 MailB is not implemented";    String RSQueryInvalidQueryCount = "Invaild Query Count %d";    String RSQueryInvalidPacketSize = "Invalid Packet Size %d";    String RSQueryLessThanFour = "Received Packet is too small. Less than 4 bytes %d";    String RSQueryInvalidHeaderID = "Invalid Header Id %d";    String RSQueryLessThanTwelve = "Received Packet is too small. Less than 12 bytes %d";    String RSQueryPackReceivedTooSmall = "Received Packet is too small. %d";    // LPD Client Logging event strings     String RSLPDDataFileSaved = "Data file saved to %s";    String RSLPDControlFileSaved = "Control file save to %s";    String RSLPDDirectoryDoesNotExist = "Directory %s doesn\'t exist";    String RSLPDServerStartTitle = "Winshoes LPD Server %s ";    String RSLPDServerActive = "Server status: active";    String RSLPDQueueStatus = "Queue %s status: %s";    String RSLPDClosingConnection = "closing connection";    String RSLPDUnknownQueue = "Unknown queue %s";    String RSLPDConnectTo = "connected with %s";    String RSLPDAbortJob = "abort job";    String RSLPDReceiveControlFile = "Receive control file";    String RSLPDReceiveDataFile = "Receive data file";    // LPD Exception Messages     String RSLPDNoQueuesDefined = "Error: no queues defined";    // Trivial FTP Exception Messages     String RSTimeOut = "Timeout";    String RSTFTPUnexpectedOp = "Unexpected operation from %s:%d";    String RSTFTPUnsupportedTrxMode = "Unsupported transfer mode: \'%s\'";    String RSTFTPDiskFull = "Unable to complete write request, progress halted at %d bytes";    String RSTFTPFileNotFound = "Unable to open %s";    String RSTFTPAccessDenied = "Access to %s denied";    // MESSAGE Exception messages     String RSTIdTextInvalidCount = "Invalid Text count. TIdText must be greater than 1";    String RSTIdMessagePartCreate = "TIdMessagePart can not be created.  Use descendant classes. ";    // POP Exception Messages     String RSPOP3FieldNotSpecified = " not specified";    // Telnet Server     String RSTELNETSRVUsernamePrompt = "Username: ";    String RSTELNETSRVPasswordPrompt = "Password: ";    String RSTELNETSRVInvalidLogin = "Invalid Login.";    String RSTELNETSRVMaxloginAttempt = "Allowed login attempts exceeded, good bye.";    String RSTELNETSRVNoAuthHandler = "No authentication handler has been specified.";    String RSTELNETSRVWelcomeString = "Indy Telnet Server";    String RSTELNETSRVOnDataAvailableIsNil = "OnDataAvailable event is nil.";    // Telnet Client     String RSTELNETCLIConnectError = "server not responding";    String RSTELNETCLIReadError = "Server didn\'t respond.";    // Network Calculator     String RSNETCALInvalidIPString = "The string %s doesn\'t translate into a valid IP.";    String RSNETCALCInvalidNetworkMask = "Invalid network mask.";    String RSNETCALCInvalidValueLength = "Invalid value length: Should be 32.";    String RSNETCALConfirmLongIPList = "There is too many IP addresses in the specified range (%d) to be displayed at design time.";    // About Box stuff     String RSAAboutFormCaption = "About";    String RSAAboutBoxCompName = "Internet Direct (Indy)";    String RSAAboutMenuItemName = "About Internet &Direct (Indy) %s...";    String RSAAboutBoxVersion = "Version %s";    String RSAAboutBoxCopyright = "Copyright � 1993 - 2000\r\n"            + "Kudzu (Chad Z. Hower)\r\n"            + "and the\r\n"            + "Indy Pit Crew";    String RSAAboutBoxPleaseVisit = "Please visit us at our website for the "            + "latest updates and information.";    String RSAAboutBoxIndyWebsite = "http://www.nevrona.com/indy/";    String RSAAboutCreditsCoordinator = "Project Coordinator";    String RSAAboutCreditsCoCordinator = "Project Co-Coordinator";    // Tunnel messages     String RSTunnelGetByteRange = "Call to %s.GetByte [property Bytes] with index <> [0..%d]";    String RSTunnelTransformErrorBS = "Error in transformation before send";    String RSTunnelTransformError = "Transform failed";    String RSTunnelCRCFailed = "CRC Failed";    String RSTunnelConnectMsg = "Connecting";    String RSTunnelDisconnectMsg = "Disconnect";    String RSTunnelConnectToMasterFailed = "Can\'t connect to the Master server";    String RSTunnelDontAllowConnections = "Don\'t allow connctions now";    String RSTunnelMessageTypeError = "Message type recognition error";    String RSTunnelMessageHandlingError = "Message handling failed";    String RSTunnelMessageInterpretError = "Interpretation of message failed";    String RSTunnelMessageCustomInterpretError = "Custom message interpretation failed";    // Socks messages     String RSSocksRequestFailed = "Request rejected or failed.";    String RSSocksRequestServerFailed = "Request rejected because SOCKS server cannot connect.";    String RSSocksRequestIdentFailed = "Request rejected because the client program and identd report different user-ids.";    String RSSocksUnknownError = "Unknown socks error.";    String RSSocksServerRespondError = "Socks server didn\'t respond.";    String RSSocksAuthMethodError = "Invalid socks authentication method.";    String RSSocksAuthError = "Authentication error to socks server.";    String RSSocksServerGeneralError = "General SOCKS server failure.";    String RSSocksServerPermissionError = "Connection not allowed by ruleset.";    String RSSocksServerNetUnreachableError = "Network unreachable.";    String RSSocksServerHostUnreachableError = "Host unreachable.";    String RSSocksServerConnectionRefusedError = "Connection refused.";    String RSSocksServerTTLExpiredError = "TTL expired.";    String RSSocksServerCommandError = "Command not supported.";    String RSSocksServerAddressError = "Address type not supported.";    // FTP     String RSDestinationFileAlreadyExists = "Destination file already exists.";    // SSL messages    String RSSSLAcceptError = "Error accepting connection with SSL.";    String RSSSLConnectError = "Error connecting with SSL.";    String RSSSLSettingChiperError = "SetCipher failed.";    String RSSSLCreatingContextError = "Error creating SSL context.";    String RSSSLLoadingRootCertError = "Could not load root certificate.";    String RSSSLLoadingCertError = "Could not load certificate.";    String RSSSLLoadingKeyError = "Could not load key, check password.";    String RSSSLGetMethodError = "Error geting SSL method.";    String RSSSLDataBindingError = "Error binding data to SSL socket.";    // IdMessage Component Editor    String RSMsgCmpEdtrNew = "&New Message Part...";    String RSMsgCmpEdtrExtraHead = "Extra Headers Text Editor";    String RSMsgCmpEdtrBodyText = "Body Text Editor";    // IdICMPClient    String RSICMPNotEnoughtBytes = "Not enough bytes received";    String RSICMPNonEchoResponse = "Non-echo type response received";    String RSICMPWrongDestination = "Received someone else\'s packet";    // IdNNTPServer    String RSNNTPServerNotRecognized = "command not recognized (%s)";    String RSNNTPServerGoodBye = "Goodbye";    // IdGopherServer    String RSGopherServerNoProgramCode = "Error: No program code to return request!";    // IdOpenSSL    String RSOSSLModeNotSet = "Mode has not been set.";    String RSOSSLCouldNotLoadSSLLibrary = "Could not load SSL library.";    String RSOSSLStatusString = "SSL status: \'%s\'";    String RSOSSLConnectionDropped = "SSL connection has dropped.";    String RSOSSLCertificateLookup = "SSL certificate request error.";    String RSOSSLInternal = "SSL library internal error.";    // IdWinsockStack    String RSWSockStack = "Winsock stack";}