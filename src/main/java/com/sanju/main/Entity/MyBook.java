package com.sanju.main.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data    // Lombok annotation for getters, setters, toString, equals, hashCode
@NoArgsConstructor  // Required by JPA
@AllArgsConstructor // Useful for creating instances
@Table(name = "books")
public class MyBook {
	
   @Id // Marks this field as primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)   // More efficient than AUTO- Auto-generates ID values
	private Integer id;
   
   @Column(nullable = false)  // Make title required
	private String title;
   
   @Column(nullable = false)
	private String author;
   @Column(length = 50)  // Specify column length
	private String genre;
   
   @Column(nullable = false, updatable = false, name = "created_at")
   @CreationTimestamp
   private LocalDateTime createdAt;
   
   @Column(name = "updated_at")
   @UpdateTimestamp
   private LocalDateTime updatedAt;
}


