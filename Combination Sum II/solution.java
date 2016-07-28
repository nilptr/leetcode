public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>(candidates.length);
        for (int num : candidates) list.add(num);
        Collections.sort(list);

        return combinationSum2(list, target);
    }

    public List<List<Integer>> combinationSum2(List<Integer> candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (candidates.size() == 0) return ret;
        if (target < candidates.get(0)) return ret;

        if (target == candidates.get(0)) {
            ret.add(Arrays.asList(candidates.get(0)));
            return ret;
        }

        if (candidates.size() == 1) return ret;

        int first = candidates.get(0);
        List<Integer> left;

        // 不适用头部的重复元素
        int idx = 0;
        while (++idx < candidates.size() && candidates.get(idx) == first);
        left = candidates.subList(idx, candidates.size());
        ret.addAll(combinationSum2(left, target));

        // 1 -> 2 -> 3 -> ...
        left = candidates.subList(1, candidates.size());
        List<List<Integer>> results = combinationSum2(left, target - first);
        for (List<Integer> list: results) {
            List<Integer> tmp = new ArrayList<>(list.size() + 1);
            tmp.add(first);
            tmp.addAll(list);
            ret.add(tmp);
        }

        return ret;
    }
}