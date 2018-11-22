package com.app.lucasgiuri.profinder2;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.app.lucasgiuri.profinder2.Models.Profesor;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;

import java.util.ArrayList;
import java.util.List;

public class SwipeActivity extends AppCompatActivity implements CardStackListener {

    private CardStackLayoutManager manager;
    private List<Profesor> profesores;
    private CardStackView cardStackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        profesores = getProfesores();

        manager = new CardStackLayoutManager(getApplicationContext(), this);
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(5);
        manager.setDirections(Direction.FREEDOM);
        manager.setCanScrollHorizontal(true);
        manager.setCanScrollVertical(true);
        CardStackAdapter adapter = new CardStackAdapter(this, profesores);
        cardStackView = findViewById(R.id.swipeStack);
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);

        FloatingActionButton btnLike = findViewById(R.id.btnLike);
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.setSwipeAnimationSetting(sendCardTo(Direction.Right));
                cardStackView.swipe();
            }
        });


        FloatingActionButton btnDislike = findViewById(R.id.btnDislike);
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.setSwipeAnimationSetting(sendCardTo(Direction.Left));
                cardStackView.swipe();
            }
        });

        FloatingActionButton btnSuperLike = findViewById(R.id.btnSuperLike);
        btnSuperLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.setSwipeAnimationSetting(sendCardTo(Direction.Top));
                cardStackView.swipe();
            }
        });

    }

    private SwipeAnimationSetting sendCardTo(Direction dir) {
        return new SwipeAnimationSetting.Builder()
                .setDirection(dir)
                .setDuration(200)
                .setInterpolator(new AccelerateInterpolator())
                .build();
    }

    private List<Profesor> getProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        profesores.add(new Profesor("Natalia", "https://wwwassets.rand.org/content/rand/capabilities/solutions/evaluating-the-effectiveness-of-teacher-pay-for-performance/jcr:content/par/solution.aspectfit.868x455.jpg/x1495297066677.jpg.pagespeed.ic.eXhh5jlMEM.jpg"));
        profesores.add(new Profesor("Celeste", "https://i1.wp.com/www.buenconsejo-madrid.com/wp-content/uploads/profesores-tutores-1.jpg?w=795"));
        profesores.add(new Profesor("Lautaro", "https://www.las2orillas.co/wp-content/uploads/2017/04/PROFESOR.jpg"));

        profesores.add(new Profesor("Ernesto", "http://www.aulaplaneta.com/wp-content/uploads/2015/10/recurso364.jpg"));
        profesores.add(new Profesor("Florencia", "http://i2.wp.com/educaon.es/wp-content/uploads/2016/06/profesor2-votatuprofesor.com_.jpg?w=759"));
        profesores.add(new Profesor("Camila", "https://static3.elcorreo.com/www/multimedia/201807/10/media/cortadas/matematicas-profesores-koFF-U60310447108i0C-624x385@El%20Correo.jpg"));

        profesores.add(new Profesor("Lucas", "http://cubranews.com.ar/wp-content/uploads/2016/12/profesores.jpg"));
        profesores.add(new Profesor("Gabriel", "https://static.vix.com/es/sites/default/files/styles/large/public/imj/imujer/5/5-tipos-de-profesores-que-nunca-vas-a-olvidar-2.jpg?itok=IMj_sO6R"));
        profesores.add(new Profesor("Marina", "https://static.vix.com/es/sites/default/files/styles/large/public/imj/entrepadres/1/10-cosas-que-los-profesores-esperan-de-los-padres-1.jpg?itok=cuCdIeA_"));

        return profesores;
    }


    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {
        if (direction == Direction.Right) {
            Log.d("Dev", manager.getTopPosition() + " to right");
        } else if (direction == Direction.Left) {
            Log.d("Dev", manager.getTopPosition() + " to left");
        } else if (direction == Direction.Top) {
            Log.d("Dev", manager.getTopPosition() + " to top");
        } else {
            // cardStackView.rewind();
        }

    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }
}
