package Util.PageUtil;

public class Pages {
    public static int PageCompute(int PageNo){
        return (PageNo-1)*9;
    }

    public static int TotalPage(int count){
        return ((count-1)/9)+1;
    }
}
