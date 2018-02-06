package com.xspace.ui.template;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xspace.module.BaseModule;
import com.xspace.module.TemplateModule;

import demo.pplive.com.xspace.R;

/**
 * Created by jixiongxu on 2018/1/31.
 */

public class TemplateFilmDisco extends BaseView
{

    public static final String Template_ID = "template_film_disco";

    private Context context;

    private View mRootView;

    private SimpleDraweeView poster;

    private SimpleDraweeView icon;

    private TextView title;

    private TextView subTitle;

    public TemplateFilmDisco(Context context)
    {
        super(context);
        this.context = context;
        initView();
    }

    private void initView()
    {
        this.setOrientation(VERTICAL);

        this.setLayoutParams(new LayoutParams(-1, -2));

        this.setPadding(0, 0, 0, 10);

        mRootView = View.inflate(mContext, R.layout.template_film, null);

        poster = mRootView.findViewById(R.id.poster);

        icon = mRootView.findViewById(R.id.icon);

        title = mRootView.findViewById(R.id.title);

        subTitle = mRootView.findViewById(R.id.subtitle);

        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);
        icon.getHierarchy().setRoundingParams(roundingParams);
        poster.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(20f));

        this.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onItemClick(module);
            }
        });
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
    public void fillData(BaseModule module)
    {
        if (!(module instanceof TemplateModule))
        {
            return;
        }

        title.setText(((TemplateModule) module).title == null ? "" : ((TemplateModule) module).title);

        subTitle.setText(((TemplateModule) module).subtitle == null ? "" : ((TemplateModule) module).subtitle);

        poster.setImageURI(
                Uri.parse(((TemplateModule) module).img_url == null ? "" : ((TemplateModule) module).img_url));

        icon.setImageURI(Uri.parse(((TemplateModule) module).icon == null ? "" : ((TemplateModule) module).icon));

        addTemplateView();
    }

    @Override
    public void addTemplateView()
    {
        addView(mRootView);
    }

    @Override
    public void reFresh()
    {

    }
}