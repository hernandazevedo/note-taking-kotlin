## Introduction
This is a simple note-taking app for creating, editing and saving notes. You are expected to complete the application using `MainActivity`  and `ChangeNoteActivity` with `RecyclerView`.

## Problem Statement
Implement or rewrite the following functionalities:
* Each item shows a `note title` in `RecyclerView`.
* Recently saved notes are added to the end of `RecyclerView`.
* `welcome_fragment` with `welcome_message` and `CreateNoteButton()` are displayed if there aren’t any other notes visible.
* Clicking on the `list item`  triggers  `ChangeNoteActivity` with data from the selected item.
* `CreateNoteButton` adds a new note to the list and starts `ChangeNoteActivity` with the recently added item.
* The app returns `field_not_be_empty_error` if a field `Title` is empty.
* Clicking on the `SaveButton` saves the note, adds it to the list and returns to the `MainActivity`.

## Hints
* String constants should be taken in `string.xml`

## Note
Please be careful when editing `build.gradle` in your project. This task as it is doesn’t require any changes to it. It is generally ok to add new dependencies but changing or removing existing dependencies or configuration can cause the project and verification tests to not function in the expected way and give a unreliable score.


## A brief description:

* domain: Business rules and interfaces on how to interact with services and repositories.
* presentation: Logic that connects the business rules with the UI. Manipulation of data for
  view.
* data: Implementations of services and repositories.

## Decisions

### Why MVVM?

As alternative to MVP, MVVM takes advantage of the reactive programming to decrease the coupling between the presentation
and the business layer. In that case the same viewModel could be used in many screens.
Check this presentation I´ve made about it some time ago:
[MVVM - Presentation](https://docs.google.com/presentation/d/1NspsJ7r8qn7x7RMFNGNiFSrDhX2qBV59w5fAAUxi_Fs/edit?usp=sharing)

### Do I like tests?

Yes, thats why that architecture was chosen in the first place. But given the time I had to make the whole project, I´ve made one test for view model.
The other classes like, repository, usecase, are pretty easy to test because they have only the logic they need to handle(separation of concerns)

### What to improve (that I can remember for now)

* Add dependency injection
* Test other classes, like repository, usecase.
* Add ci, cd
* Add code checkstyle with detekt
* Add kotlin kts to build system, and configure all dependencies o a Dependency.kt file for 