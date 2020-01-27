public class ParseQuote {
    String parsePage(String data){
        String startString = "</header>    <div class=\"quote__body\">";
        String endString = "<footer class=\"quote__footer\">";
        int startIndex = data.indexOf(startString);
        int endIndex = data.indexOf(endString);
        data = data.substring(startIndex + startString.length(), endIndex - 17);
        return replaceSymbols(data);
    }

    String replaceSymbols(String data){
        return data
                .replaceAll("&lt","<")
                .replaceAll("&gt",">")
                .replaceAll("&quot","\"")
                .replaceAll("<br />", "\n");
    }
}
