# JEDI-2.0-Group-B-Java-Project-POS
# FlipFit - Your Ultimate Fitness Companion 💪🏋️‍♀️

Welcome to FlipFit, where we transform your fitness journey into a seamless, hassle-free experience. Get ready to sweat it out, book your favorite fitness center slots, and embark on a healthier lifestyle with just a few clicks! 🎉🏆

## Table of Contents 📜

- [Introduction](#introduction)
- [Functional Requirements](#functional-requirements)
  - [User Registration](#user-registration)
  - [View All Centers](#view-all-centers)
  - [View Gym Availability](#view-gym-availability)
  - [Booking a Slot](#booking-a-slot)
  - [Prevent Overbooking (Bonus)](#prevent-overbooking-bonus)
  - [View User's Plan (Bonus)](#view-users-plan-bonus)
  - [Slot Cancellation (Bonus)](#slot-cancellation-bonus)
- [Non-Functional Requirements](#non-functional-requirements)
- [Actors & Their Roles](#actors--their-roles)
- [UML Diagrams](#uml-diagrams)

## Introduction 🌟

FlipFit is your one-stop solution for all your fitness needs. We provide a user-friendly platform that allows you to register, explore fitness centers, book available slots, and manage your workout plans effortlessly. Let's get started on your fitness journey!

## Functional Requirements 🏋️‍♂️

### User Registration 📝

Users can kickstart their fitness adventure by signing up with their personal details, including name, phone number, and a secure password.

### View All Centers 🏢

Explore a comprehensive list of fitness centers near you. Get acquainted with each center's name, location, and available workout slots.

### View Gym Availability 🕒

Check the availability of slots for a specific fitness center on a chosen day. Discover available slots and the number of remaining seats for each.

### Booking a Slot 🎟️

Secure your workout slot at a preferred fitness center, date, and time, provided seats are available. Our system confirms bookings only when there are enough seats. Duplicate bookings for the same time slot are automatically removed, and waitlisted users are notified.

### Prevent Overbooking (Bonus) ⚠️

We've got you covered! Our system ensures no overbooking occurs at any fitness center. If a slot is fully booked, users receive an error message.

### View User's Plan (Bonus) 🗓️

Track your fitness journey effortlessly. View your workout plan based on the selected day and fitness center. Keep tabs on your booked slots and waiting list status.

### Slot Cancellation (Bonus) 🚫

Life happens, and we understand. Users have the option to cancel their booked slots, allowing others to benefit. Our system updates seat availability and promotes the next user on the waiting list when applicable.

## Non-Functional Requirements 🧩

- **Modular Code:** Our codebase follows a modular structure, making it easy to maintain and extend.

- **Design Principles (SOLID):** We adhere to SOLID design principles to ensure robust and scalable code.

- **Extensible Code Design:** FlipFit's codebase is designed with extensibility in mind, allowing for future enhancements and features.

## Actors & Their Roles 🎭

In the FlipFit system, various actors interact with the application:

1. **Users / Gym Users:** The primary users of the system who can register, view fitness centers, check slot availability, book slots, view their plans, cancel bookings, and receive notifications.

2. **FlipFit System / Super Admin:** An administrative user with special privileges. They can onboard new users and fitness centers, manage slot information, oversee system operation, and even assist in auto-assigning confirmed seats to waitlisted candidates.

3. **Gym Owner / Fitness Center:** These actors input slot information, manage fitness center details, and provide top-notch facilities to our valued customers.


