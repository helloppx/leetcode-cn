//效率一般....
    public static List<List<Integer>> threeSum() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, 0, 0};

        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int each : nums) {
            Integer n = map.getOrDefault(each, 0);
            map.put(each, n + 1);
        }

        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer find = -nums[i] - nums[j];
                Integer z = map.getOrDefault(find, 0);
                if (z == 0) {
                    continue;
                }
                if (find == nums[i]) {
                    z--;
                }
                if (find == nums[j]) {
                    z--;
                }
                if (z != 0) {
                    List<Integer> t = new LinkedList<>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(find);
                    Collections.sort(t);
                    res.add(t);
                }
            }
        }

        return new ArrayList(res);
    }
