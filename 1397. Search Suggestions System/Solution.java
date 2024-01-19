class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> results = new ArrayList<>();
        
        for (int i = 1; i <= searchWord.length(); i++) {
            String currentSearchWord = searchWord.substring(0, i);
            List<String> currentSearchResults = new ArrayList<>();
            
            /* iterate through products. if  products .startsWith currentsearchword:
                add it to currentsearchresults. limit 3. add to List and break if size is 3. 
                if size never reaches 3, gotta add whatever you have to the List */
            for (String product : products) {
                if (product.startsWith(currentSearchWord)) {
                    currentSearchResults.add(product);
                    if (currentSearchResults.size() == 3) {
                        results.add(currentSearchResults);
                        break;
                    }
                }
            }
            if (currentSearchResults.size() < 3) {
                results.add(currentSearchResults);
            }
        }
        
        return results;
    }
}