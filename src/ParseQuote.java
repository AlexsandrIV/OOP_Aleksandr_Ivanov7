/**
 * @author Aleksandr_Ivanov7
 */

public class ParseQuote {
    private String page;

    /**
     *
     * @param page this page for parse
     */
    public ParseQuote(String page) {
        this.page = page;
    }

    /**
     *
     * @param data this page cut header and footer
     * @return parse quote from page
     */
    String parsePage(String data){
        String startString = "</header>    <div class=\"quote__body\">";
        String endString = "<footer class=\"quote__footer\">";
        int startIndex = data.indexOf(startString);
        int endIndex = data.indexOf(endString);
        data = data.substring(startIndex + startString.length(), endIndex - 17);
        return replaceSymbols(data);
    }

    /**
     *
     * @param numberQuote true if page exist/false if no exist or null
     * @return true if page exist
     */
    boolean checkExistPage(int numberQuote){
        if (page == null){
            return false;
        }
        return page.contains("<a class=\"quote__header_permalink\" href=\"/quote/" + numberQuote);
    }

    /**
     *
     * @param data
     * @return page without html-symbols
     */
    String replaceSymbols(String data){
        return data
                .replaceAll("&lt","<")
                .replaceAll("&gt",">")
                .replaceAll("&quot","\"")
                .replaceAll("<br />", "\n")
                .replaceAll(";","");
    }
}
