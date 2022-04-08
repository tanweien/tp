---
layout: page
title: Eugene Chia's Project Portfolio Page
---

### Project: NUSearch

NUSearch is a desktop app for managing NUS staff contacts, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).
The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the ability to undo/redo commands.
    * What it does: allows the user to undo previous commands one at a time. Preceding undo commands can be reversed by using the redo command.
    * Justification: This feature improves the product significantly because a user can make mistakes in commands and the app should provide a convenient way to rectify them.
    * Highlights: This enhancement affects existing commands and commands to be added in the future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.
    * Credits: Took inspiration from the [memento model](https://medium.com/design-patterns-in-python/memento-pattern-eba610b3b59c)

* **New Feature**: Add optional Telegram field to contacts
  * What it does: allows the user to create contacts with optional Telegram fields
  * Justification: This simulates the use case of faculty members having the choice of including their Telegram handle.
  * Highlights: This enhancement uses the Optional Java class which helps to ensure errors are thrown at appropriate junctures.

* **Code contributed**: [RepoSense link]()

* **Project management**:
    * Managed releases `v1.3` - `v1.5rc` (3 releases) on GitHub

* **Enhancements to existing features**:
    * Updated the GUI color scheme (Pull requests [\#33](), [\#34]())
    * Wrote additional tests for existing features to increase coverage from 72% to 77% (Pull requests [\#36](), [\#38]())

* **Documentation**:
    * User Guide:
        * Added documentation for the features `delete` and `find` [\#72]()
        * Did cosmetic tweaks to existing documentation of features `clear`, `exit`: [\#74]()
    * Developer Guide:
        * Added implementation details of the `delete` feature.

* **Community**:
    * PRs reviewed (with non-trivial review comments): [\#12](), [\#32](), [\#19](), [\#42]()
    * Contributed to forum discussions (examples: [1](https://github.com/nus-cs2103-AY2122S2/forum/issues/191), [2](https://github.com/nus-cs2103-AY2122S2/forum/issues/117), [3](), [4]())
    * Reported bugs and suggestions for other teams in the class (examples: [1](), [2](), [3]())