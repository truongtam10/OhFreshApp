package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Offer extends AppCompatActivity {

    TextView txtOfferContent;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        linkViews();
        customizeContent();
        addEvents();
    }

    private void linkViews() {
        txtOfferContent = findViewById(R.id.txtOfferContent);
        btnBack = findViewById(R.id.btnBack);
    }

    private void customizeContent() {
        String text =
                "<font color=#FF9330><b>\uD83E\uDD57 MỪNG BẠN CŨ QUAY LẠI, TA CŨNG ĂN LỚN ƯU ĐÃI GIẢM 60% \uD83E\uDD57</b></font>"
                + "<br><br>" +"\uD83E\uDD52 Lâu lắm rồi không gặp, dạo này bạn khỏe không?"
                + "<br>" + "\uD83E\uDD55 Oh!Fresh thì nhớ bạn lắm đó! Để kỷ niệm ngày ta gặp lại nhau, Oh!Fresh mang đến ưu đãi <b>giảm 50%</b> đây!"
                + "<br><br>" + "\uD83D\uDC49 Đừng quên nhập mã nè:"
                + "<br>" + "<font color=#FF9330><b>\uD83C\uDF89 GAPLAI60 \uD83C\uDF89</b></font> <font color=#00B761>giảm ngay 60k</font> cho đơn hàng từ 120k."
                + "<br>" + "<font color=#FF9330><b>\uD83C\uDF89 GAPLAI90 \uD83C\uDF89</b></font> <font color=#00B761>giảm ngay 90k</font> cho đơn hàng từ 200k."
                + "<br><br>" + "\uD83D\uDE0D Cần gì thì cứ <font color=#00B761>Oh!Fresh thôi!</font>";
        txtOfferContent.setText(Html.fromHtml(text));
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}