/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let sumMap = new Map();
    for (let i = 0; i < nums.length; i++) {
        if (sumMap.has(target - nums[i])) {
            return [i, sumMap.get(target - nums[i])];
        } else {
            sumMap.set(nums[i], i);
        }
    }
    throw new Error("No two sum solution.")
};