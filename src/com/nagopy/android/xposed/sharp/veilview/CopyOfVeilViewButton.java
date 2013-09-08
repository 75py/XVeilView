
package com.nagopy.android.xposed.sharp.veilview;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Xposedで取得したjp.co.sharp.android.systemui.statusbar.phone.
 * VeilViewButtonをごにょごにょして使用するためのクラス
 * 
 * @author 75py <dev.75py@gmail.com>
 */
public class CopyOfVeilViewButton {

    private final WeakReference<Object> thisObject;

    private final WeakReference<Method> getStatus;
    private final WeakReference<Method> doON;
    private final WeakReference<Method> doOFF;

    public CopyOfVeilViewButton(Object thisObject, Method getStatus, Method doON,
            Method doOFF) {
        this.thisObject = new WeakReference<Object>(thisObject);
        this.getStatus = new WeakReference<Method>(getStatus);
        this.doON = new WeakReference<Method>(doON);
        this.doOFF = new WeakReference<Method>(doOFF);
    }

    public void doON() throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        doON.get().invoke(thisObject.get());
    }

    public void doOFF() throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        doOFF.get().invoke(thisObject.get());
    }

    public Boolean getState() throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        return (Boolean) getStatus.get().invoke(thisObject.get());
    }

    public Boolean isActive() {
        return isNotNull(thisObject) && isNotNull(getStatus) && isNotNull(doON)
                && isNotNull(doOFF);
    }

    private <T> Boolean isNotNull(WeakReference<T> obj) {
        return obj.get() != null;
    }

    @Override
    public String toString() {
        return "CopyOfVeilViewButton [thisObject=" + thisObject + ", getStatus=" + getStatus
                + ", doON=" + doON + ", doOFF=" + doOFF + "]";
    }
}
