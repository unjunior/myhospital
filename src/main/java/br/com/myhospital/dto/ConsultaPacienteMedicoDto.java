package br.com.myhospital.dto;

import br.com.myhospital.entidades.Consulta;

import java.time.LocalDateTime;

public class ConsultaPacienteMedicoDto {

    private Long id;
    private LocalDateTime horario;
    private PacienteDto paciente;
    private MedicoDto medico;

    public ConsultaPacienteMedicoDto() {
    }

    public ConsultaPacienteMedicoDto(Long id, LocalDateTime horario, PacienteDto paciente, MedicoDto medico) {
        this.id = id;
        this.horario = horario;
        this.paciente = paciente;
        this.medico = medico;
    }

    public ConsultaPacienteMedicoDto(Consulta entity) {
        id = entity.getId();
        horario = entity.getHorario();
        paciente = new PacienteDto(entity.getPaciente());
        medico = new MedicoDto(entity.getMedico());
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public PacienteDto getPaciente() {
        return paciente;
    }

    public MedicoDto getMedico() {
        return medico;
    }
}
