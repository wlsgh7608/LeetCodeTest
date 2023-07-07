import java.util.*;
class Solution {


    static void dfs(int idx){
       if(idx==N){
           if(arr[0]==arr[1] && arr[1]==arr[2] && arr[2]==arr[3]){
               isTrue = true;
           }
          return ;
       }
       int cur = sticks[idx];
        for(int i = 0 ;i <4;i++){
            if(arr[i]+cur<=sum/4){
                arr[i]+=cur;
                dfs(idx+1);
                arr[i]-= cur;
            }
            if(isTrue){
                return;
            }
            
        }
    }

    static int N;
    static boolean isTrue;
    static Integer[] sticks;
    static int [] arr;
    static int sum;
    public boolean makesquare(int[] matchsticks) {
        N = matchsticks.length;
        sticks = new Integer[N];
        for(int i = 0; i<N;i++){
            sticks[i] = matchsticks[i];
        }

        Arrays.sort(sticks,(o1,o2)->o2-o1);
        isTrue = false;
        sum = 0;
        arr = new int[4];
        
        for(int stick : matchsticks){
            sum+=stick;
        }
        
        if(sum%4 !=0){
            return false;
        }

        dfs(0);

        
        if(isTrue){
            return true;
        }else{
            return false;
        }
    }
}