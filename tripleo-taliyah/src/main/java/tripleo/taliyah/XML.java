package tripleo.taliyah;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        s.trim();
        if (s.length() > 0) {
            print("characters", s);
        }
    }

    private void print(String context, String text) {
        System.out.println(context + ": \"" + text + "\"");

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//		super.endElement(uri, localName, qName);
        print("endElement", qName);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        print("startElement", qName);
        for (int j = 0; j < attributes.getLength(); j++) {
            String qname = attributes.getQName(j),
                    value = attributes.getValue(j);
            print("  attr", qname + " " + value);
        }
    }
}
