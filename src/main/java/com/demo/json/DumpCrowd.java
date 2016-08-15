package com.demo.json;

public class DumpCrowd extends DumpCircle {

    public static Crowd parseCrowd(DumpCrowd dumpCrowd) {
        return new Crowd(dumpCrowd.getId(), dumpCrowd.getName());
    }

}
