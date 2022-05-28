package com.cg.cricketleague.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;


@Entity
@Table(name = "matches")
public class Match {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "match_id")
	private int matchId;
	
	@NotBlank(message = "Match name is mandatory")
	@Column(name = "match_name")
	private String matchName;
	
	@ManyToOne
	private Tournament tournament;
	
	@JsonIgnore
	@OneToMany (mappedBy = "match")
	private List<Audience> audiences;
	
	public Match() {
		
	}

	public Match(int matchId, String matchName, Tournament tournament, List<Audience> audiences) {
		this.matchId = matchId;
		this.matchName = matchName;
		this.tournament = tournament;
		this.audiences = audiences;
	}

	public Match(int matchId) {

		this.matchId = matchId;
	}
	
	

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public List<Audience> getAudiences() {
		return audiences;
	}

	public void setAudiences(List<Audience> audiences) {
		this.audiences = audiences;
	}

	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", matchName=" + matchName + ", tournament=" + tournament + ", audiences="
				+ audiences + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(audiences, matchId, matchName, tournament);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		return matchId == other.matchId || matchName == other.getMatchName();
	}

	
	
}
