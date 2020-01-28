public class ParseQuote {
    private String page;

    public ParseQuote(String page) {
        this.page = page;
    }

    String parsePage(String data){
        String startString = "</header>    <div class=\"quote__body\">";
        String endString = "<footer class=\"quote__footer\">";
        int startIndex = data.indexOf(startString);
        int endIndex = data.indexOf(endString);
        data = data.substring(startIndex + startString.length(), endIndex - 17);
        return replaceSymbols(data);
    }

    boolean checkExistPage(int numberQuote){
        if (page == null){
            return false;
        }
        return page.contains("<a class=\"quote__header_permalink\" href=\"/quote/" + numberQuote);
    }

    String replaceSymbols(String data){
        return data
                .replaceAll("&lt","<")
                .replaceAll("&gt",">")
                .replaceAll("&quot","\"")
                .replaceAll("<br />", "\n");
    }
}
