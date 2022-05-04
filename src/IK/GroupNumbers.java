package IK;

public class GroupNumbers {

    /*
            * Complete the function below.
            */
    static int[] solve(int[] arr) {
        if (arr == null) {
            return arr;
        }

        // int[] newArr = new int[arr.length];
        // int e = 0;
        // int o = newArr.length - 1;
        // int i = 0;
        // while(i < arr.length) {
        //     int v = arr[i];

        //     if(v % 2 == 0){
        //         // even
        //         newArr[e] = v;
        //         e++;
        //     } else {
        //         // odd
        //         newArr[o] = v;
        //         o--;
        //     }
        //     i++;
        // }

        // i = 0;
        // while(i < arr.length) {
        //     arr[i] = newArr[i];
        //     i++;
        // }


        int i = 0;
        int e = 0;
        int o = arr.length - 1;

        while (e < o) {
            // find first odd
            while (arr[e] % 2 == 0 && e < o) {
                e++;
            }

            while (o > e && arr[o] % 2 == 1) {
                o--;
            }


            //swap e and o
            int t = arr[e];
            arr[e] = arr[o];
            arr[o] = t;

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; // {2,2,2};//{1,1,1,1}; //{1,2,3,4}; //{1,2,3,4,5};

        int[] r = solve(arr);

        for (int i :
                r) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
