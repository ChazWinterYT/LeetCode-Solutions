class Solution {
    public int leastInterval(char[] tasks, int n) {
        /* The way this code works, when I set a cooldown period,
            it is immediately decremented before the cycle is complete.
            Therefore, I need to set the cooldown to one extra cycle to compensate. */
        final int cooldownPeriod = n + 1;
        // Track the cooldown period (n) for each char
        int[] cooldown = new int[26];
        // Get the task count for each char and rank these counts, descending
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );
        maxHeap.addAll(map.keySet());
        int totalTime = 0;
        
        /* Try the highest priority task. If cooldown is 0, perform it,
            decr its count, reinsert into maxHeap with new count. 
            If it can't be performed, try the next task.
            if no tasks can be performed (nextTask is '#'), insert an idle task. */
        while (!maxHeap.isEmpty()) {
            char nextTask = selectNextTask(maxHeap, cooldown);
            if (nextTask != '#') {
                cooldown[nextTask - 'A'] = cooldownPeriod;   // Selected task requires a cooldown
                /* You poll-ed the task that was selected. It needs to be returned 
                to the Queue with its new count (if it's not zero) */
                int newTaskCount = map.get(nextTask) - 1;
                if (newTaskCount == 0) {
                    map.remove(nextTask);
                } else {
                    map.put(nextTask, newTaskCount);
                    maxHeap.offer(nextTask);
                }
            }
            decrementCooldown(map, cooldown);
            totalTime++;
        }
        return totalTime;
    }
    
    /* Method to find a task in the PriorityQueue that can be executed. */
    private char selectNextTask(PriorityQueue<Character> maxHeap, int[] cooldown) {
        List<Character> rejectedTasks = new ArrayList<>();
        char taskToExecute = '#';
        while (maxHeap.size() != 0) {
            Character taskToTry = maxHeap.poll();
            if (cooldown[taskToTry - 'A'] == 0) {
                taskToExecute = taskToTry;
                break;
            } else {
                rejectedTasks.add(taskToTry);
            }
        }
        // Put all rejected tasks back into the PriorityQueue
        if (!rejectedTasks.isEmpty()) maxHeap.addAll(rejectedTasks);
        return taskToExecute;   // This will be '#' if no tasks can be selected
    }
    
    /* Method to decrement all tasks with a cooldown */
    private void decrementCooldown(Map<Character, Integer> map, int[] cooldown) {
        for (char c : map.keySet()) {
            if (cooldown[c - 'A'] > 0) {
                cooldown[c - 'A']--;
            }
        }
    }
}