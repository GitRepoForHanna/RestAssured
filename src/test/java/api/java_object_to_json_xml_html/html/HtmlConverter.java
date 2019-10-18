package api.java_object_to_json_xml_html.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

public class HtmlConverter {

    public static final String HTML_DOC_TEMPLATE = "<html><title id='doc_title'></title><body></body></html>";

    public static Attribute createAttribute(String key, String value) {
        return new Attribute(key, value);
    }

    public static void addAttributeToElement(Element element, Attribute attribute) {
        element.attributes().put(attribute);
    }

    public static Document createNewDocument() {
        return Jsoup.parse(HTML_DOC_TEMPLATE);
    }

    public static Document createNewDocument(String docTitle) {
        Document document =  Jsoup.parse(HTML_DOC_TEMPLATE);
        document.title(docTitle);
        return document;
    }

    public static Document insertDocument(Document parentDocument, Document childDocument) {
        parentDocument.body().append(childDocument.body().toString());
        return parentDocument;
    }

    public static Document joinDocument(List<Document> documents, String groupName) {
        Document resultDocument = createNewDocument(groupName);
        documents.forEach(document -> {
            resultDocument.body().append(document.body().toString());
        });
        return resultDocument;
    }

    public static void insertChildNode(Element parentElement, Element childElement) {
        parentElement.append(childElement.toString());
    }

    public static void insertChildNodes(Element parentElement, List<Element> childElements) {
        childElements.forEach(childElement -> parentElement.append(childElement.toString()));
    }
}
