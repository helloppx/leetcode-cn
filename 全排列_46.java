import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 全排列_46 {
    public static void main(String[] args) {
        全排列_46 m = new 全排列_46();
        int[] array = new int[]{1, 2, 3, 4};
        List<List<Integer>> permute = m.permute(array);
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> x = new LinkedList<>();
            x.add(nums[0]);
            res.add(x);
            return res;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int each : nums) {
            int[] remain = remove(nums, each);
            List<List<Integer>> tmp = permute(remain);
            for (List<Integer> list : tmp) {
                list.add(0, each);
            }
            res.addAll(tmp);
        }
        return res;
    }

    private int[] remove(int[] nums, int i) {
        if (nums.length == 0) {
            return nums;
        }
        if (nums.length == 1) {
            return new int[0];
        }
        int[] res = new int[nums.length - 1];
        int in = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != i) {
                res[in++] = nums[j];
            }
        }
        return res;
    }
}

