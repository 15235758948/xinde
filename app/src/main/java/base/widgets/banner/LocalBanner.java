package base.widgets.banner;

/**
 * Created by Administrator on 2017/3/29.
 */

public class LocalBanner {
    public LocalBanner(int localRes){
        this.localRes=localRes;
    }
    private int localRes;
    public int getLocalRes(){
        return localRes;
    }
    public void setLocalRes(int localRes){
        this.localRes=localRes;
    }
}
