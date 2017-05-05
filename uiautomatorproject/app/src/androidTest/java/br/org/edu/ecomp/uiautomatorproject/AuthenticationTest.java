package br.org.edu.ecomp.uiautomatorproject;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class AuthenticationTest extends AutomatedTest {

    public void testLoginSuccess() throws UiObjectNotFoundException {

        UiObject login = mDevice.findObject(new UiSelector().descriptionContains("login"));
        UiObject password = mDevice.findObject(new UiSelector().descriptionContains("password"));
        UiObject btnEnter = mDevice.findObject(new UiSelector().descriptionContains("enterButton"));

        login.click();
        login.setText("teste@gmail.com");

        password.click();
        password.setText("123456");

        btnEnter.click();

        UiObject edtPhone = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/edt_phone"));

        assertTrue(edtPhone.exists());

    }

    public void testLoginInvalidEmail() throws UiObjectNotFoundException {

        UiObject login = mDevice.findObject(new UiSelector().descriptionContains("login"));
        UiObject password = mDevice.findObject(new UiSelector().descriptionContains("password"));
        UiObject btnEnter = mDevice.findObject(new UiSelector().descriptionContains("enterButton"));

        login.click();
        login.setText("teste@teste.com");

        password.click();
        password.setText("123456");

        btnEnter.click();

        UiObject popup = mDevice.findObject(new UiSelector().text("Login Inválido"));

        assertTrue(popup.exists());

        UiObject message = mDevice.findObject(new UiSelector().textContains("Por favor informe um email válido !"));

        assertTrue(message.exists());

    }

    public void testLoginInvalidPassword() throws UiObjectNotFoundException {

        UiObject login = mDevice.findObject(new UiSelector().descriptionContains("login"));
        UiObject password = mDevice.findObject(new UiSelector().descriptionContains("password"));
        UiObject btnEnter = mDevice.findObject(new UiSelector().descriptionContains("enterButton"));

        login.click();
        login.setText("teste@gmail.com");

        password.click();
        password.setText("12346");

        btnEnter.click();

        UiObject popup = mDevice.findObject(new UiSelector().text("Login Inválido"));

        assertTrue(popup.exists());

        UiObject message = mDevice.findObject(new UiSelector().textContains("Por favor informe uma senha válida !"));

        assertTrue(message.exists());

    }

}
