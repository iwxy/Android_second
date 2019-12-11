package edu.pxxy.wxy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.pxxy.wxy.R;
import edu.pxxy.wxy.bean.Food;

public class FoodAdapter extends BaseAdapter {
    //数据源与数据适配器进行关联
    private List<Food> mList;//一个集合，写在TtemBean中
    private LayoutInflater mInflater;

    public FoodAdapter(Context context, List<Food> list){
        mList=list;
        mInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        //返回ListVIew所需要显示的数据量
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        //集合的位置
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        //获得id
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //定义一个类
        ViewHolder viewHolder;

        if(view==null){

            //对ViewHolder类进行实例化
            viewHolder=new ViewHolder();

            //加载item布局
            view=mInflater.inflate(R.layout.food_item,null);

            /*
             *第一个参数是要加载的布局
             *第二个参数一般默认设置为null
             *
             */

            //寻找ViewHolder中控件的Id,
            viewHolder.foodName= view.findViewById(R.id.food_name);
            viewHolder.foodPrice= view.findViewById(R.id.food_price);

            viewHolder.count=  view.findViewById(R.id.food_count);

            //通过setTag将view与ViewHolder绑定
            view.setTag(viewHolder);
        }else{
            //通过ViewHolder对象找到对应的空文件
            viewHolder= (ViewHolder) view.getTag();
        }

        Food food=mList.get(i);

        //对ViewHolder类中的控件进行赋值

        viewHolder.foodName.setText(food.getFoodName());
        viewHolder.foodPrice.setText((int) food.getFoodPrice()+" ");

        viewHolder.count.setText(String.valueOf(food.getCount()));

        //返回一个View
        return view;
    }

    /*
     *创建一个内部类ViewHolder
     * 为了避免findViewById的重复的操作
     */
    class ViewHolder{
        private TextView foodName;
        private TextView foodPrice;
        private TextView  count;
    }
}

