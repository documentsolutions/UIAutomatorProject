package br.org.edu.ecomp.uiautomatorproject;

import android.os.RemoteException;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

public class HomeTest extends  AutomatedTest{

    public void testAddPhoneSuccess() throws RemoteException, UiObjectNotFoundException {

        login();

        UiObject edtName = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/edt_name"));

        UiObject edtPhone = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/edt_phone"));

        UiObject btnAdd = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/btn_add"));

        edtName.setText("Andre Miranda");

        edtPhone.click();
        edtPhone.setText("3428-1536");

        btnAdd.click();

    }

    public void testAddPhoneWithEmptyData() throws RemoteException, UiObjectNotFoundException {

        login();

        UiObject edtName = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/edt_name"));

        UiObject edtPhone = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/edt_phone"));

        UiObject btnAdd = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/btn_add"));

        edtName.setText("");

        edtPhone.click();
        edtPhone.setText("");

        btnAdd.click();

        UiObject item = mDevice.findObject(new UiSelector().resourceId("android:id/text1").index(0));
        assertTrue(!item.exists());

    }

    public void testAddPhoneWithoutName() throws RemoteException, UiObjectNotFoundException {

        login();

        UiObject edtName = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/edt_name"));

        UiObject edtPhone = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/edt_phone"));

        UiObject btnAdd = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/btn_add"));

        edtName.setText("");

        edtPhone.click();
        edtPhone.setText("123456");

        btnAdd.click();

        UiObject item = mDevice.findObject(new UiSelector().resourceId("android:id/text1").index(0));
        assertTrue(!item.exists());

    }

    public void testAddPhoneWithoutPhone() throws RemoteException, UiObjectNotFoundException {

        login();

        UiObject edtName = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/edt_name"));

        UiObject edtPhone = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/edt_phone"));

        UiObject btnAdd = mDevice.findObject(new UiSelector()
                .resourceId("br.edu.poli.aplicationtest:id/btn_add"));

        edtName.setText("teste name");

        edtPhone.click();
        edtPhone.setText("");

        btnAdd.click();

        UiObject item = mDevice.findObject(new UiSelector().resourceId("android:id/text1").index(0));
        assertTrue(!item.exists());

    }
}
