package com.xp.java.exercise;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/29 0029 16:11
 * @修改人：
 * @修改时间：2018/9/29 0029 16:11
 * @修改备注：
 */
public class TestInstance {
    public interface LifeCycler {
    }

    public interface IView {
    }

    static class SupportActivity {
    }

    static class Activity extends SupportActivity implements IView, LifeCycler {
        public IView view;
        public LifeCycler cycler;

        public Activity() {
            view = this;
            cycler = this;
        }

        public boolean isHas() {
            return view instanceof LifeCycler;
        }

        public boolean isHasCycler() {
            return cycler instanceof IView;
        }

        public boolean isHasActivity() {
            return cycler instanceof Activity;
        }

        public boolean isHasSupportActivity() {
            return cycler instanceof SupportActivity;
        }
    }

    public static void main(String[] args) {
        Activity activity = new Activity();
        System.out.println(activity.isHas());
        System.out.println(activity.isHasCycler());
        System.out.println(activity.isHasActivity());
        System.out.println(activity.isHasSupportActivity());
    }
}
