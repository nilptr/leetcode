public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : candidates) list.add(num);
        Collections.sort(list);

        return combinationSum(list, target);
    }

    // [2,3,6,7] 7 => [7],[2,2,3]
    // [1,2] 2 => [1,1],[2]
    // [1] 2 => [1,1]
    private List<List<Integer>> combinationSum(List<Integer> sortedArr, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        if (sortedArr.size() == 0) return ret;
        if (sortedArr.get(0) > target) return ret;

        if (target % sortedArr.get(0) == 0) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < target / sortedArr.get(0); ++i)
                tmp.add(sortedArr.get(0));
            ret.add(tmp);
        }

        int first = sortedArr.get(0);
        List<Integer> left = sortedArr.subList(1, sortedArr.size());

        for (int i = 0; target - i * first > 0; ++i) {
            List<List<Integer>> result = combinationSum(left, target - i * first);
            for (List<Integer> cb : result) {
                List<Integer> tmp = new ArrayList<Integer>(cb.size() + i);
                for (int j = 0; j < i; ++j) {
                    tmp.add(first);
                }
                tmp.addAll(cb);
                ret.add(tmp);
            }
        }

        return ret;
    }
}