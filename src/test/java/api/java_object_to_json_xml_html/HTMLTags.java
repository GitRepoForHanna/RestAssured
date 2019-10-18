package api.java_object_to_json_xml_html;

public enum HTMLTags {
    HTML("html"),
    TITLE("title"),
    BODY("body"),
    DIV("div"),
    A("a"),
    TABLE("table"),
    THEAD("thead"),
    TBODY("tbody"),
    TH("th"),
    TR("tr"),
    TD("td"),
    H1("h1"),
    H2("h2"),
    H3("h3"),
    H4("h4"),
    H5("h5"),
    H6("h6");

    private String tag;

    HTMLTags(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
