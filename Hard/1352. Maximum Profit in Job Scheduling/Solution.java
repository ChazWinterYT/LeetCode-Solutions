class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[profit.length];
        for (int i = 0; i < profit.length; i++) {
            jobs[i] = new Job(i, startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.getEndTime() - b.getEndTime());
        
        int[] dp = new int[jobs.length];
        dp[0] = jobs[0].getProfit();
        
        for (int i = 1; i < jobs.length; i++) {
            // Determine the profit if we KEEP the current job.
            int profitIfJobKept = jobs[i].getProfit();
            int bestOtherJobIndex = findLastEligibleJob(jobs, jobs[i], i);
            if (bestOtherJobIndex != -1) {
                profitIfJobKept += dp[bestOtherJobIndex];
            }
            // Determine if this improves our situation. If not, just keep the previous situation.
            if (profitIfJobKept >= dp[i - 1]) {
                dp[i] = profitIfJobKept;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        
        return dp[dp.length - 1];
    }
    
    private int findLastEligibleJob(Job[] jobs, Job currentJob, int endIndex) {
        int left = 0, right = endIndex - 1; // Minus 1 so you don't choose the current job.
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid].getEndTime() <= currentJob.getStartTime()) {
                left = mid + 1;
            } else {    // This job overlaps with the current job (it's to the right of the answer).
                right = mid - 1;
            }
        }
        return right;   // This returns -1 if no eligible jobs exist.
    }
}

/* For each job, you can either KEEP it or SKIP it.
    if you KEEP it, then add its profit to maxProfit from jobs that end before it starts.
    if you SKIP it, then just accept the max profit to this point. */

class Job {
    private int id;
    private int startTime;
    private int endTime;
    private int profit;
    
    public Job (int id, int startTime, int endTime, int profit) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
    
    public int getStartTime() {
        return this.startTime;
    }
    
    public int getEndTime() {
        return this.endTime;
    }
    
    public int getProfit() {
        return this.profit;
    }
    
    @Override
    public String toString() {
        return String.format("Job %d: %d - %d. Profit: %d", id, startTime, endTime, profit);
    }
}