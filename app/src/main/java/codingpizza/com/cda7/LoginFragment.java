package codingpizza.com.cda7;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText mEmail_et;
    private EditText mPassword;
    private Button mSignUpButton;
    private Button mLoginButton;

    //Creamos nuestro listener
    onSignUpSelectedListener mListener;


    public LoginFragment() {
        // Todos los Fragments deben contener este constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Inicializamos el listener y nos aseguramos que la activity implemente esta interfaz
        //De lo contrario lanzamos una Exepcion
        try {
            mListener = (onSignUpSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnSignUpSelectedListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creamos el layout del fragment que le vamos a pasar a la Activity
        //Declaramos las views
       View view = inflater.inflate(R.layout.fragment_login, container, false);
        mEmail_et = view.findViewById(R.id.et_email);
        mPassword = view.findViewById(R.id.et_password);
        mSignUpButton = view.findViewById(R.id.sign_up_button);
        mLoginButton = view.findViewById(R.id.login_button);

        //Creamos los onClickListeners para los botones

        //Si el usuario no tiene cuenta y tiene que registrarse utilizamos el metodo signUp
        //Donde le comunicamos a la actividad de cambiar de fragment
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        //Si el usuario inicia sesión, llamamos al metodo Login()
        //En este caso no vamos a hacer una super validación basta que validemos si no son vacios los campos

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        return view;
    }


    //Metodo que llamamos al hacer click en el boton de login
    private void Login() {
        if (!mEmail_et.getText().toString().isEmpty() || !mPassword.getText().toString().isEmpty()){
            Toast.makeText(getContext(), "Hemos iniciado sesión", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Ha ocurrido un error, revisa que los datos sean correctos.", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo que llamamos si usamos el metodo de registrarnos
    private void signUp() {
        Toast.makeText(getContext(), "Cambiando a signUp...", Toast.LENGTH_SHORT).show();
        mListener.onSignUpSelected();

    }

    //Creamos una interfaz que debe implementar la Activity
    public interface onSignUpSelectedListener{
        void onSignUpSelected();
    }

}
