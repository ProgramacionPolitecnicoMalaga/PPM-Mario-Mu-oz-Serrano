package com.politecnicomalaga.factory_method;

import com.politecnicomalaga.viewer.DataViewer;
import com.politecnicomalaga.viewer.TextDataViewer;

public class ViewerFactoryText implements ViewerFactory{
    @Override
    public DataViewer crearViewer() {
        return new TextDataViewer();
    }
}
