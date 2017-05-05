package br.org.edu.ecomp.uiautomatorproject;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.After;
import org.junit.Before;

public class AutomatedTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public UiDevice mDevice;

    private static final String BASIC_SAMPLE_PACKAGE
            = "br.edu.poli.aplicationtest";

    private Context context;

    public AutomatedTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        context = InstrumentationRegistry.getContext();

        launchApp();
    }

    private void launchApp() throws RemoteException, UiObjectNotFoundException {

        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

    }

    public void login() throws UiObjectNotFoundException {

        UiObject login = mDevice.findObject(new UiSelector().descriptionContains("login"));
        UiObject password = mDevice.findObject(new UiSelector().descriptionContains("password"));
        UiObject btnEnter = mDevice.findObject(new UiSelector().descriptionContains("enterButton"));

        login.click();
        login.setText("teste@gmail.com");

        password.click();
        password.setText("123456");

        btnEnter.click();

    }


}
