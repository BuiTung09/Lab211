/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author win
 */
public enum CandidateType {
    EXPERIENCE(0, "Experience"), FRESHER(1, "Fresher"), INTERN(2, "Intern");
    private int mode;
    private String value;

    private CandidateType(int mode, String value) {
        this.mode = mode;
        this.value = value;
    }

    public static CandidateType getCandidateType(int mode) {
        switch (mode) {
            case 0:
                return EXPERIENCE;
            case 1:
                return FRESHER;
            case 2:
                return INTERN;
        }
        throw new AssertionError();
    }

    public String getValue() {
        return value;
    }

    public int getMode() {
        return mode;
    }
    
}
