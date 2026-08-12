/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Doctor;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author win
 */
public class DoctorManager {

    private Map<String, Doctor> doctorMap;

    public DoctorManager() {
        doctorMap = new HashMap<>();
    }

    public Map<String, Doctor> getDoctorMap() {
        return doctorMap;
    }

    public void setDoctorMap(Map<String, Doctor> doctorMap) {
        this.doctorMap = doctorMap;
    }

    public boolean addDoctor(Doctor doctor) throws Exception {
        if (doctorMap.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code [" + doctor.getCode() + "] is duplicate.");
        }
        doctorMap.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean updateDoctor(Doctor doctor) throws Exception {
        if (!doctorMap.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn’t exist.");
        }
        doctorMap.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean deleteDoctor(String code) throws Exception {
        if (!doctorMap.containsKey(code)) {
            throw new Exception("Doctor code doesn’t exist.");
        }
        if (doctorMap.remove(code) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Map<String, Doctor> searchDoctor(String input) {
        Map<String, Doctor> result = new HashMap<>();
        for (Doctor doctor : doctorMap.values()) {
            if (doctor.getCode().toLowerCase().contains(input.toLowerCase())
                    || doctor.getName().toLowerCase().contains(input.toLowerCase())
                    || doctor.getSpecialization().toLowerCase().contains(input.toLowerCase())) {
                result.put(doctor.getCode(), doctor);
            }
        }
        return result.isEmpty() ? null : result;
    }

    @Override
    public String toString() {
        if (doctorMap.isEmpty()) {
            return null;
        }
        // Sử dụng TreeMap để sắp xếp theo khóa (code)
        Map<String, Doctor> sortedDoctorMap = new TreeMap<>(doctorMap);

        String result = String.format("%-10s %-20s %-20s %-10s\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor doctor : sortedDoctorMap.values()) {
            result += String.format("%-10s %-20s %-20s %-10d\n", doctor.getCode(), doctor.getName(),
                    doctor.getSpecialization(), doctor.getAvailability());
        }
        return result;
    }
}
