class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedRooms = new HashSet<>();
        visitRooms(rooms, visitedRooms, 0); 
            
        return (visitedRooms.size() == rooms.size());
    }
    
    private static void visitRooms(List<List<Integer>> rooms, Set<Integer> visitedRooms, int currentRoom) {
        if (visitedRooms.contains(currentRoom)) return; // Base case
        
        visitedRooms.add(currentRoom);
        
        for (int key : rooms.get(currentRoom)) {
            visitRooms(rooms, visitedRooms, key);
        }
    }
}