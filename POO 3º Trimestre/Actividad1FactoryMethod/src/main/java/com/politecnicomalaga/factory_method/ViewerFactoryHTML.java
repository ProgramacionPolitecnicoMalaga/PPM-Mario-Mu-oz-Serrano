package com.politecnicomalaga.factory_method;

import com.politecnicomalaga.viewer.DataViewer;
import com.politecnicomalaga.viewer.HTMLDataViewer;

public class ViewerFactoryHTML implements ViewerFactory{

    @Override
    public DataViewer crearViewer() {
        return new HTMLDataViewer();
    }
}
