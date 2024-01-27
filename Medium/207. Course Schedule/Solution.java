class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        // Populate the HashMap with courses and their prereqs
        for (int i = 0; i < numCourses; i++) {
            courseMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            List<Integer> prereqList = courseMap.get(prereq[0]);
            prereqList.add(prereq[1]);
            courseMap.put(prereq[0], prereqList);
        }
        
        boolean[] visited = new boolean[numCourses];
        
        // For each course, provide its own copy of an "onPath" array
        // If this individual copy of an array gets a repeat value, then a cycle is detected
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, courseMap, visited, new boolean[numCourses])) {
                return false; // Cycle was detected
            }
        }
        // If the loop survives, no cycle detected!
        return true;
    }
    
    private boolean dfs(int course, Map<Integer, List<Integer>> courseMap,
                       boolean[] visited, boolean[] onPath) {
        if (onPath[course]) return false; // Course is on current path already, cycle detected
        if (visited[course]) return true; // Course was checked in a previous iteration and was fine
        
        // Mark the course visited and on the current path
        visited[course] = true;
        onPath[course] = true;
        
        for (int prereq : courseMap.get(course)) {
            if (!dfs(prereq, courseMap, visited, onPath)) {
                return false;
            }
        }
        
        /* if the loop survives, then no cycle detected (for ex. the List above was empty)!
         * don't forget to "undo" the onPath flag before going back up the call stack
         * you can also remove all prereqs for the course that you know is good to go (no need to
         * calculate that it is valid again)
         */
        onPath[course] = false;
        courseMap.put(course, new ArrayList<>());
        return true;
    }
}