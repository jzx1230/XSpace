package com.xspace.ui.template;

import android.content.Context;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xspace.module.BaseModule;
import com.xspace.module.TemplateModule;
import com.xspace.utils.DisplayUtil;

public class TemplateCover extends BaseView
{
    public static String Template_ID = "template_cover";

    private SimpleDraweeView simpleDraweeView;

    private TextView subtitle;

    public TemplateCover(Context context)
    {
        super(context);
        initView();
    }

    private void initView()
    {
        this.setOrientation(VERTICAL);
        this.setGravity(Gravity.CENTER);
        this.setPadding(0, 0, 0, 10);
        this.setLayoutParams(new LayoutParams(-1, -2));

    }

    @Override
    public void setData(BaseModule module)
    {
        if (module == null)
        {
            return;
        }
        this.module = module;
        fillData(module);
    }

    @Override
    public void fillData(final BaseModule module)
    {
        if (module == null || !(module instanceof TemplateModule))
        {
            return;
        }

        if (simpleDraweeView == null)
        {
            simpleDraweeView = new SimpleDraweeView(mContext);
        }
        if (subtitle == null)
        {
            subtitle = new TextView(mContext);
        }
        int width = DisplayUtil.screenWidthPx(mContext);
        this.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onItemClick(module);
            }
        });
        simpleDraweeView.setLayoutParams(new LayoutParams(width, (int) (width * 0.33333)));
        simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
        subtitle.setText(((TemplateModule) module).subtitle);
        subtitle.setPadding(20, 20, 0, 0);
        simpleDraweeView.setImageURI(Uri.parse(((TemplateModule) module).img_url));
        addTemplateView();
    }

    @Override
    public void addTemplateView()
    {
        addView(simpleDraweeView);
        addView(subtitle);
        invalidate();
    }

    @Override
    public void reFresh()
    {

    }
}
