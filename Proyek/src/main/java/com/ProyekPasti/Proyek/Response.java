package com.ProyekPasti.Proyek;

public class Response<RT,VT,MT> {
    RT response;
    VT value;
    MT message;

    public Response(){}

    public Response(RT response, MT message) {
        this.response = response;
        this.message = message;
    }

    public Response(RT response, VT value, MT message) {
        this.response = response;
        this.value = value;
        this.message = message;
    }

    public RT getResponse() {
        return response;
    }

    public void setResponse(RT response) {
        this.response = response;
    }

    public VT getValue() {
        return value;
    }

    public void setValue(VT value) {
        this.value = value;
    }

    public MT getMessage() {
        return message;
    }

    public void setMessage(MT message) {
        this.message = message;
    }
}
