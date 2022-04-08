---
layout: page
title: Shurvir Arora's Project Portfolio Page
---

### Project: NUSearch

NUSearch is a desktop app for managing NUS contacts, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).
The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the ability to find contacts via their tag. (tag ...)
    * What it does: allows the user to find all contacts based on the tag they're associated with.
    * Justification: This feature improves the product significantly because a user could find trouble in finding contacts initially and may want to organise their contacts further by assigning a tag to them. As such, with this feature they can filter out contacts based on the tag specified.
    * Highlights: This enhancement affects some existing commands. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.

* **New Feature**: Added the Role field for each contact.
    * What it does: allows the user to add a role for each contact
    * Justification: This feature improves the product significantly because a user could now further organise their contacts by specifying the role of each contact. This also makes  the application university specific, hence contributing to the  context.
    * Highlights: This enhancement affects some existing commands. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.

* **New Feature**: Added the ability to find contacts matching **any** of the keywords (keywords: Name, Faculty, Role). (find-wide ...)
  * What it does: allows the user to find all contacts that match **any** of the keywords specified.
  * Justification: This feature improves the product significantly because a user could now find contacts not just by Name but also by their Faculty and Role. This also allows users to broaden their search results as contacts that match any of the keywords specified will show up in the result list.
  * Highlights: This enhancement affects some existing commands. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.

* **New Feature**: Added the ability to find contacts matching **all** of the keywords (keywords: Name, Faculty, Role). (find ...)
  * What it does: allows the user to find all contacts that match **all** of the keywords specified.
  * Justification: This feature improves the product significantly because a user could now find contacts not just by Name but also by their Faculty and Role. This also allows users to narrow down their search results as only contacts that match all the keywords specified will show up in the result list.
  * Highlights: This enhancement affects some existing commands. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=shurvirarora&tabRepo=AY2122S2-CS2103T-W11-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false)

* **Project management**:
    * Managed releases `v1.1` - `v1.3` (4 releases) on GitHub

* **Enhancements to existing features**:
    * Updated the Find feature to include Faculty and Role in addition to Name.
    * Wrote additional tests for existing features to increase coverage from 88% to 92% (Pull requests [\#36](), [\#38]())

* **Documentation**:
    * User Guide:
        * Added documentation for the features `delete` and `find` [\#72]()
        * Did cosmetic tweaks to existing documentation of features `clear`, `exit`: [\#74]()
    * Developer Guide:
        * Added implementation details of the `delete` feature.

* **Community**:
    * PRs reviewed (with non-trivial review comments): [\#12](), [\#32](), [\#19](), [\#42]()
    * Contributed to forum discussions (examples: [1](), [2](), [3](), [4]())
    * Reported bugs and suggestions for other teams in the class (examples: [1](), [2](), [3]())
    * Some parts of the history feature I added was adopted by several other class mates ([1](), [2]())

* **Tools**:
    * Integrated a third party library (Natty) to the project ([\#42]())
    * Integrated a new Github plugin (CircleCI) to the team repo

* _{you can add/remove categories in the list above}_
