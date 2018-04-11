package codingpizza.com.cda7;


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
public class SignUpFragment extends Fragment {

    private EditText mEmail_et;
    private EditText mPassword_et;
    private EditText mConfirmPassword_et;
    private Button mSignUpButton;


    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creamos el layout del fragment que le vamos a pasar a la Activity

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        //Declaramos las views

        mEmail_et = view.findViewById(R.id.et_email);
        mPassword_et = view.findViewById(R.id.et_password);
        mConfirmPassword_et = view.findViewById(R.id.et_confirm_password);
        mSignUpButton = view.findViewById(R.id.sign_up_button);

        //Creamos el onClickListener para el boton de registro
        //Este onClickListener llama al metodo signUp que se encarga del inicio de sesion
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        return view;
    }

    //En este metodo verificamos si los campos no estan vacios
    private void signUp() {
        if (!mEmail_et.getText().toString().isEmpty() || !mPassword_et.getText().toString().isEmpty()){
            //Si los campos no estan vacios  las contraseñas conciden mostramos el toast de registro
            if (arePasswordEquals()){
                Toast.makeText(getContext(), "Bienvenido has sido registrado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Las contrasenas no coinciden", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "Has llenado todos los campos?", Toast.LENGTH_SHORT).show();
        }
    }

    //Funcion que verifica si ambas contraseñas son iguales
    private boolean arePasswordEquals() {
        return mPassword_et.getText().toString().equals(mConfirmPassword_et.getText().toString());
    }




}
