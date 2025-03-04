package br.com.myhospital.dto;

import br.com.myhospital.entidades.Consulta;
import br.com.myhospital.entidades.Medico;
import br.com.myhospital.entidades.Paciente;

import java.time.LocalDateTime;

public class ConsultaDto {

    private Long id;
    private LocalDateTime horario;
    private Medico medico;
    private Paciente paciente;

    public ConsultaDto() {
    }

    public ConsultaDto(Long id, LocalDateTime horario, Medico medico, Paciente paciente) {
        this.id = id;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
    }

    public ConsultaDto(Consulta entity) {
        id = entity.getId();
        horario = entity.getHorario();
        medico = entity.getMedico();
        paciente = entity.getPaciente();
    }
}
