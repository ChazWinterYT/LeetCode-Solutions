class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        UnionFind uf = new UnionFind(10000); // 1000 * 10, worst case for unique emails
        int id = 0;
        
        /* Map each email to the name it belongs to, for later retrieval.
            This is a waste of memory, as it's only used to build the final lists,
            but I don't understand how to do it more efficiently */
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                emailToName.putIfAbsent(account.get(i), name);
            }
        }
        
        // Map each email to a unique id, and union all emails in the same account
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToId.putIfAbsent(email, id++);
                uf.union(emailToId.get(firstEmail), emailToId.get(email));
            }
        }
        
        /* For each unique email found previously, find its parent
            For that parent, append all its child email addresses
            to a TreeSet (which orders them alphabetically) */
        Map<Integer, Set<String>> groups = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int rootId = uf.find(emailToId.get(email));
            groups.computeIfAbsent(rootId, x -> new TreeSet<>()).add(email);
        }
        
        // Now we have the graph set up. Let's build the result!
        List<List<String>> result = new ArrayList<>();
        for (Set<String> group : groups.values()) {
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(emailToName.get(group.iterator().next()));
            mergedAccount.addAll(group);
            result.add(mergedAccount);
        }
        return result;
    }
}

class UnionFind {
    private int[] parent;
    
    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}