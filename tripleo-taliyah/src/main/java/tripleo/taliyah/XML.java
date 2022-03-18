package tripleo.taliyah;

import tripleo.taliyah.swingui.TaliyahForm;
import tripleo.util.Assert;

import javax.swing.*;
import javax.xml.parsers.*;
import java.awt.*;
import java.util.*;
import java.io.IOException;

import FreeBASE.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;


final class XML {
	static XMLReader makeXMLReader() throws ParserConfigurationException, SAXException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		XMLReader parser = saxParser.getXMLReader();
		return parser;
	}
}

class Sink extends DefaultHandler implements ContentHandler {
	@Override
	        public void characters(char ch[], int start, int length) throws SAXException {
		String s = new String(ch, start, length);
		s.trim();
		if (s.length() > 0)
			print ("characters", s);
	}

	private void print(String context, String text) {
		System.out.println(context+": \""+text+"\"");

	}

	@Override
	        public void endElement(String uri, String localName, String qName) throws SAXException {
//		super.endElement(uri, localName, qName);
		print ("endElement", qName);
	}

	@Override
	        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		print ("startElement", qName);
		for (int j = 0; j < attributes.getLength(); j++) {
			String qname = attributes.getQName(j),
			        value = attributes.getValue(j);
			print ("  attr", qname+" "+value);	
		}
	}
}
