package br.com.myhospital.dto;

import br.com.myhospital.entidades.Consulta;

import java.time.LocalDateTime;

public class ConsultaDto {

    private Long id;
    private LocalDateTime horario;
    private Long medicoId;
    private Long pacienteId;

    public ConsultaDto() {
    }

    public ConsultaDto(Long id, LocalDateTime horario, Long pacienteId) {
        this.id = id;
        this.horario = horario;
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
    }

    public ConsultaDto(Consulta entity) {
        id = entity.getId();
        horario = entity.getHorario();
        medicoId = entity.getMedico().getId();
        pacienteId = entity.getPaciente().getId();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }
}
