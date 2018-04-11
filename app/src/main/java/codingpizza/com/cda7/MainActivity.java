package codingpizza.com.cda7;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoginFragment.onSignUpSelectedListener {

    private FragmentManager mFragmentManager;
    private LoginFragment mLoginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginFragment = new LoginFragment();

        mFragmentManager = getSupportFragmentManager();

        mFragmentManager.beginTransaction()
                .add(R.id.fragment_container, mLoginFragment)
                .commit();
    }


    @Override
    public void onSignUpSelected() {
        SignUpFragment signUpFragment = new SignUpFragment();
        mFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, signUpFragment)
                .commit();
    }
}
