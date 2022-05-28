package com.cg.cricketleague.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private int teamId;

	@NotBlank(message = "Team name is mandatory")
	@Column(name = "team_name")
	private String teamName;

	@ManyToOne
	private Match match;

	@JsonIgnore
	@OneToMany(mappedBy = "team")
	private List<Player> players;

	@JsonIgnore
	@OneToOne(mappedBy = "team")
	private Owner owner;

	public Team() {
		super();
	}

	public Team(int teamId, String teamName, Match match, List<Player> players, Owner owner) {
		this.teamId = teamId;
		this.teamName = teamName;
		this.match = match;
		this.players = players;
		this.owner = owner;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", match=" + match + ", players=" + players
				+ ", owner=" + owner + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(match, owner, players, teamId, teamName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return teamId == other.teamId || teamName == other.getTeamName();
	}

}
