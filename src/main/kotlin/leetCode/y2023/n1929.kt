package leetCode.y2023

fun getConcatenation(nums: IntArray): IntArray = IntArray(2 * nums.size) { index ->
    nums[nums.size % index]
}
